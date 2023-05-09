package admi.knn.build.division;

import admi.knn.data.Instance;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrossValidation implements Division{

    private int k = 3;
    public CrossValidation(int k){
        this.k = k;
    }
    @Override
    public List<Data> getDataSet(List<Instance> initData) {
        dataSet.clear();
        //the middle is null
        List<List<Instance>> lists = Lists.partition(initData,initData.size()/k);
        System.out.println("init data size is : "+initData.size());
        System.out.println("the size of the list is : "+lists.size());
        for(int i=0;i<k;i++){
            List<Instance> learning = new ArrayList<>();
            List<Instance> testing = lists.get(i);
            for(int j=0;j<k;j++)
                if(j != i)
                    learning.addAll(lists.get(j));
            System.out.printf("the size of the %d dataset is : %d ",i,testing.size());
            Data data = new Data(testing,null,learning);
            dataSet.add(data);
        }

        return dataSet;
    }
}
