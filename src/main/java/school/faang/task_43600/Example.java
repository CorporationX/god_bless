package school.faang.task_43600;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public Integer[] reverse(Integer[] array) {
        List<Integer> reversedArr = new ArrayList<>();
        for (int count = array.length - 1; count >= 0; count--) {
            reversedArr.add(array[count]);
        }
        return reversedArr.toArray(new Integer[0]);
    }

    public void printArray(Integer[] array) {
        System.out.println("Array size = " + array.length);
        for (Integer num : array) {
            System.out.println(String.format("%d", num));
        }
    }
}
