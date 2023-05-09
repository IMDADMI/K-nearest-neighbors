package admi.knn.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;

public class Instance {
    double values[];
    String className;

    public Instance(double[] values, String className) {
        this.values = values;
        this.className = className;
    }
    public Instance(String className,double ...values) {
        this.values = values;
        this.className = className;
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double[] values) {
        this.values = values;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Instance{" +
                "values=" + Arrays.toString(values) +
                ", className='" + className + '\'' +
                '}';
    }
}
