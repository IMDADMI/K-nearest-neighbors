package admi.knn.build;

import admi.knn.build.distance.DistanceAlgorithm;
import admi.knn.build.division.DivisionAlgorithm;
import admi.knn.build.knn.DistanceClass;
import admi.knn.build.knn.KnnImpl;
import admi.knn.data.Instance;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        KnnImpl knn = new KnnImpl(3);
//        KnnImpl knn = new KnnImpl(3, DivisionAlgorithm.crossValidation,4, DistanceAlgorithm.Minkowski);
        Instance instance = new Instance(null,6.9,3.1,4.9,1.5);
        System.out.println(knn.getObservedClass(instance,knn.getExistDataset()));
    }
}


















//        KnnImpl knn = new KnnImpl(3);
//        DistanceClass distanceClass2 = new DistanceClass(10.3,"hello5");
//        DistanceClass distanceClass3 = new DistanceClass(12.3,"hello5");
//        DistanceClass distanceClass4 = new DistanceClass(9.3,"hello5");
//        DistanceClass distanceClass5 = new DistanceClass(25.3,"hello8");
//        DistanceClass distanceClass6 = new DistanceClass(9.3,"hello6");
//        DistanceClass distanceClass7 = new DistanceClass(9.3,"hello7");
//        DistanceClass distanceClass8 = new DistanceClass(33.3,"hello8");
//        DistanceClass distanceClass9 = new DistanceClass(51.3,"hello82");
//
//        List<DistanceClass> classList = new ArrayList<>();
//        classList.add(distanceClass1);
//        classList.add(distanceClass2);
//        classList.add(distanceClass3);
//        classList.add(distanceClass4);
//        classList.add(distanceClass5);
//        classList.add(distanceClass6);
//        classList.add(distanceClass7);
//        classList.add(distanceClass8);
//        classList.add(distanceClass9);
//        DistanceClass.sort(classList);
//        System.out.println(classList);
//        Map<String,Integer> prediction = new HashMap<>();
//        String predicted = classList.get(0).getInstanceClass();
//        Integer max = 0;
//        for(int i=0;i<3;i++){
//            DistanceClass distanceClass = classList.get(i);
//            String className = distanceClass.getInstanceClass();
//            if(prediction.containsKey(distanceClass.getInstanceClass())){
//                Integer numberOfClasses = prediction.get(className);
//                prediction.put(className,++numberOfClasses);
//                if(max<numberOfClasses){
//                    predicted = className;
//                    max = numberOfClasses;
//                }
//            }else
//                prediction.put(className,0);
//
//
//        }
//            System.out.println("the predicted class is : "+predicted);