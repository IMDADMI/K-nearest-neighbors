package admi.knn.build.distance;

import admi.knn.data.Instance;

public class Minkowski implements Distance{


    @Override
    public Double DistanceCalculator(double[] i1, double[] i2) {
        double max = 0;
        for(int i=0;i<i1.length;i++)
            max = Math.max(max,(i1[i] - i2[i]));

        return max;
    }
}
