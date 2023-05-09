package admi.knn.build.knn;

import admi.knn.build.distance.*;
import admi.knn.build.division.*;
import admi.knn.data.ExtractData;
import admi.knn.data.Instance;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLOutput;
import java.util.*;

import static admi.knn.data.ExtractData.classes;

public class KnnImpl implements Knn{
    private Integer K = -1;
    private Distance distance = new Euclidean();
    private Division division = new Partitioning();
    private int numberOfClasses;

    public List<Instance> dataset;
    private List<Data> dataList;

    private List<Instance> testingSet;
    private Performance performance;
    private List<Instance> validationSet;
    private List<Instance> learningSet;
    private final List<DistanceClass> distanceResult = new ArrayList<>();

    private HashMap<String,Integer> matrixAttribute = new HashMap<>();

    public KnnImpl(Integer k) throws IOException {
        K = k;
        start();
    }

    public KnnImpl(Integer k, DivisionAlgorithm divisionAlgorithm,int cross, DistanceAlgorithm distanceAlgorithm) throws Exception {
        K = k;
        division = divisionAlgorithm.equals(DivisionAlgorithm.partitioning)?new Partitioning():new CrossValidation(cross);
        final String className = "admi.knn.build.distance."+distanceAlgorithm;
        distance = (Distance) Class.forName(className).getDeclaredConstructor().newInstance();
        start();
    }
    private void start() throws IOException {
        getDataset();
        getNumberOfClasses();
        startProcessing();
    }

    private void getNumberOfClasses() {
        numberOfClasses = classes.size();
        int counter = 0;
        for (String Class : classes){
            System.out.println("the class : "+Class+" is for : "+counter);
            matrixAttribute.put(Class,counter++);
        }
    }

    private void startProcessing()  {
        dataList = division.getDataSet(dataset);
        for(int i=0;i<dataList.size();i++)
            loopThrough(i);

    }

    private void loopThrough(int index) {
        testingSet = dataList.get(index).getTest();
        learningSet = dataList.get(index).getLearning();
        validationSet = dataList.get(index).getLearning();
        int performanceMatrix[][] = new int[numberOfClasses][numberOfClasses];
        testingSet.forEach(test->{
            String reelClass = test.getClassName();
            String observedClass = getObservedClass(test,learningSet);
            performanceMatrix[matrixAttribute.get(reelClass)][matrixAttribute.get(observedClass)]++;
        });

        performance = new Performance(performanceMatrix,testingSet.size(),numberOfClasses);
    }

    private boolean ff = true;
    public String getObservedClass(Instance test, List<Instance> learningSet) {

        learningSet.forEach(e->{
            Double dis = distance.DistanceCalculator(e.getValues(),test.getValues());
            DistanceClass distanceClass = new DistanceClass(dis,e.getClassName());
            distanceResult.add(distanceClass);
        });
        return predictClass();
    }


    @Override
    public void sortResult() {
        DistanceClass.sort(distanceResult);
    }

    @Override
    public String predictClass() {
        sortResult();
        Map<String,Integer> prediction = new HashMap<>();
        String predicted = distanceResult.get(0).getInstanceClass();
        int max = 0;
        for(int i=0;i<K;i++){
            DistanceClass distanceClass = distanceResult.get(i);
            String className = distanceClass.getInstanceClass();
            if(prediction.containsKey(className)){
                Integer numberOfClasses = prediction.get(className);
                prediction.put(className,++numberOfClasses);
                if(max<numberOfClasses){
                    predicted = className;
                    max = numberOfClasses;
                }
            }else
                prediction.put(className,0);
        }
        distanceResult.clear();
        return predicted;
    }


    @Override
    public void getDataset() throws IOException {
        dataset = ExtractData.saveData("src\\data\\iris.arff");
    }
    public List<Instance> getExistDataset(){
        return this.dataset;
    }
}
