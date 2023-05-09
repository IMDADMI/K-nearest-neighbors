package admi.knn.build.knn;

public class Performance implements PerformanceMeasure{
    private int performanceMatrix[][];
    private int testSize;
    private int numberOfClasses;

    public Performance(int[][] performanceMatrix, int testSize, int numberOfClasses) {
        System.out.println("performance matrix ");
        for(int i=0;i<numberOfClasses;i++){
            for(int j=0;j<numberOfClasses;j++)
                System.out.print(performanceMatrix[i][j]+" ");
            System.out.println();
        }
        this.performanceMatrix = performanceMatrix;
        this.testSize = testSize;
        this.numberOfClasses = numberOfClasses;
        calculatePerformance();
    }

    private void calculatePerformance() {
        System.out.printf("the accuracy is : %s %%\n",String.format("%.2f",accuracy()*100));
        System.out.printf("the recall is : %s %%\n",String.format("%.2f",recall()*100));
        System.out.printf("the precision is : %s %%\n",String.format("%.2f",precision()*100));
        System.out.printf("the f_measure is : %s %%\n",String.format("%.2f",f_measure()*100));
    }

    @Override
    public double accuracy() {
        double acc = 0;
        for(int i = 0; i< numberOfClasses; i++)
            acc+=performanceMatrix[i][i];
        return acc/testSize;
    }

    @Override
    public double precision() {
        double prec = 0;
        for(int i = 0; i< numberOfClasses; i++)
            prec+= piCalculation(i);

        return prec / numberOfClasses;
    }
    private double piCalculation(int j){
        int nii = performanceMatrix[j][j];
        int n_i = calculateN_i(j);
//        System.out.println("the pi of the class : "+j+" is : "+pi);
        return n_i==0?0:(double) nii / n_i;
    }
    private double riCalculation(int j){
        int nii = performanceMatrix[j][j];
        int ni_ = calculateNi_(j);
//        System.out.println("the ri of the class : "+j+" is : "+String.format("%.2f",ri));
        return ni_==0?0:(double) nii / ni_;
    }
    private double fiCalculation(int j){
        double numerator =2*(this.piCalculation(j)*this.riCalculation(j));
        double denominator=this.piCalculation(j)+this.riCalculation(j);

        double f_mes = numerator / denominator;
//        System.out.println("the fi of the class : "+j+" is : "+f_mes);
        return f_mes;

    }
    private int calculateN_i(int i){
        int n_i = 0;
        for(int j = 0; j< numberOfClasses; j++)
            n_i+=performanceMatrix[j][i];

        return n_i;
    }
    private int calculateNi_(int i){
        int ni_ = 0;
        for(int j = 0; j< numberOfClasses; j++)
            ni_+=performanceMatrix[i][j];
        return ni_;
    }
    @Override
    public double recall() {
        double rec = 0;
        for(int i = 0; i< numberOfClasses; i++)
            rec+= riCalculation(i);

        return rec / numberOfClasses;
    }
    @Override
    public double f_measure() {
        double numerator = 2*(precision()*recall());
        double denominator = precision()+recall();
        return numerator/denominator;
    }

    public static void main(String[] args) {
        int matrix [][] = new int[3][3];
        matrix[0][0] = 1400;
        matrix[0][1] = 350;
        matrix[0][2] = 250;
        matrix[1][0] = 150;
        matrix[1][1] = 1650;
        matrix[1][2] = 100;
        matrix[2][0] = 120;
        matrix[2][1] = 170;
        matrix[2][2] = 910;
        PerformanceMeasure  performance = new Performance(matrix,5100,3);
    }
}
