package admi.knn.build.division;

import admi.knn.data.ExtractData;
import admi.knn.data.Instance;

import java.io.IOException;
import java.util.List;

public class Partitioning implements Division{
    @Override
    public List<Data> getDataSet(List<Instance> initData) {
        dataSet.clear();
        int sum = initData.size();
        int test = (20*sum)/100;
        int validation = (10*sum)/100;
        int learning = sum-(test+validation);
//        System.out.println(test);
//        System.out.println(validation);
//        System.out.println(learning);
        Data data = new Data(
                initData.subList(0,validation),
                initData.subList(validation, validation+test),
                initData.subList(validation+test,validation+test+learning));

        dataSet.add(data);
        System.out.println(dataSet.get(0).learning.size());
        System.out.println(dataSet.get(0).test.size());
        System.out.println(dataSet.get(0).validation.size());
        return dataSet;
       }

    public static void main(String[] args) throws IOException {
        Partitioning partitioning = new Partitioning();
        partitioning.getDataSet(ExtractData.saveData("src\\data\\iris.arff"));
    }
}
