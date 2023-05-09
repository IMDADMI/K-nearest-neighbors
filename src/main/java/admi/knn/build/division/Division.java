package admi.knn.build.division;

import admi.knn.data.Instance;

import java.util.ArrayList;
import java.util.List;

public interface Division {
    List<Data> dataSet = new ArrayList<>();
    List<Data> getDataSet(List<Instance> initData);
}
