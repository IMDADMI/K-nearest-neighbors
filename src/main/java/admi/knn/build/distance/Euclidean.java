package admi.knn.build.distance;

import admi.knn.data.Instance;

public class Euclidean implements Distance{

    @Override
    public Double DistanceCalculator(double[] i1, double[] i2) {
        double sum = 0;
        for(int i=0;i<i1.length;i++)
            sum = Math.pow((i1[i]-i2[i]),2);

        return Math.sqrt(sum);
    }
}
