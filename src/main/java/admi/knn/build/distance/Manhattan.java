package admi.knn.build.distance;

import admi.knn.data.Instance;

public class Manhattan implements Distance{

    @Override
    public Double DistanceCalculator(double[] i1, double[] i2) {
        double sum=0;
        for(int i=0;i<i1.length;i++)
            sum+=Math.abs(i1[i] - i2[i]);

        return sum;
    }
}
