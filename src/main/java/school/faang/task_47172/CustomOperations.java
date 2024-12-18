package school.faang.task_47172;

import java.util.ArrayList;
import java.util.List;

public class CustomOperations {
    List<Integer> integerList = new ArrayList<>();

    public int sumIntegers(List<Integer> integerList) {
        return integerList.stream().filter(intNum ->
                intNum % 2 == 1
        ).reduce(Integer::sum).orElse(0);
    }

    public int getMax(List<Integer> integerList) {
        return integerList.stream().reduce(Integer::max).orElse(0);
    }

    public double getAverage(List<Integer> integerList) {
        Double sum = integerList.stream().reduce(Integer::sum)
                .get().doubleValue();
        ;
        int size = integerList.size();
        return sum / size;
    }
}
