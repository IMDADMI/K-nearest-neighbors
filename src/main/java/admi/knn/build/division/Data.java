package admi.knn.build.division;

import admi.knn.data.Instance;

import java.util.List;

public class Data {
    List<Instance> test,validation,learning;

    public Data(List<Instance> test, List<Instance> validation, List<Instance> learning) {
        this.test = test;
        this.validation = validation;
        this.learning = learning;
    }

    public List<Instance> getTest() {
        return test;
    }

    public void setTest(List<Instance> test) {
        this.test = test;
    }

    public List<Instance> getValidation() {
        return validation;
    }

    public void setValidation(List<Instance> validation) {
        this.validation = validation;
    }

    public List<Instance> getLearning() {
        return learning;
    }

    public void setLearning(List<Instance> learning) {
        this.learning = learning;
    }

    @Override
    public String toString() {
        return "Data{" +
                "test=" + test +
                ", validation=" + validation +
                ", learning=" + learning +
                '}';
    }
}
