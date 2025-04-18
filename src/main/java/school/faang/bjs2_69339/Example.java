package school.faang.bjs2_69339;

import java.util.Collections;
import java.util.List;

public class Example {
    public static void reverseNaive(List<Integer> array) {
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            var removedNum = array.remove(j);
            array.add(i, removedNum);

            i++;
        }
    }

    public static void reverse(List<Integer> array) {
        Collections.reverse(array);
    }
}