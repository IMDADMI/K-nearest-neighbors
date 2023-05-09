package admi.knn.build.knn;

import admi.knn.data.Instance;

import java.io.IOException;
import java.util.List;

public interface Knn {
    void sortResult();
    String predictClass();
    void getDataset() throws IOException;
    }
