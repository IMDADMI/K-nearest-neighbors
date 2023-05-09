package admi.knn.build.knn;

import java.util.Comparator;
import java.util.List;

public class DistanceClass {
    private Double distance;
    private String instanceClass;

    public String getInstanceClass() {
        return instanceClass;
    }

    public void setInstanceClass(String instanceClass) {
        this.instanceClass = instanceClass;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }


    public DistanceClass(Double distance, String instanceClass) {
        this.distance = distance;
        this.instanceClass = instanceClass;
    }
    public static void sort(List<DistanceClass> classList){
        classList.sort(Comparator.comparingDouble(DistanceClass::getDistance));
    }

    @Override
    public String toString() {
        return "DistanceClass{" +
                "distance=" + distance +
                ", instanceClass='" + instanceClass + '\'' +
                '}';
    }
}
