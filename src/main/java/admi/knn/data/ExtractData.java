package admi.knn.data;

import java.io.*;
import java.util.*;


public class ExtractData {
    public ExtractData() {}
    private static List<Instance> instances = new ArrayList<>();
    public static Set<String> classes = new HashSet<>();

    public static List<Instance> saveData(String path) throws IOException {
        classes.clear();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\data\\irisData.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.trim().equals("@DATA")) {
                while ((line = reader.readLine()) != null) {
                    if (line.equals("%"))
                        break;
                    String[] instanceAsString = line.split(",");
                    double[] values = new double[4];
                    String className = instanceAsString[4];
                    classes.add(className.trim());
                    for (int i = 0; i < 4; i++)
                        values[i] = Double.parseDouble(instanceAsString[i]);
                    Instance instance1 = new Instance(values, className);
                    instances.add(instance1);
                }

                break;
            }
        }
        Collections.shuffle(instances);
        return instances;
    }
}
