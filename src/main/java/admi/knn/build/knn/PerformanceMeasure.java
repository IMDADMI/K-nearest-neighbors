package admi.knn.build.knn;

public interface PerformanceMeasure {
    double accuracy();
    double precision();

    double recall();
    double f_measure();

}
