package school.faang.reverse_example;

import java.util.Collections;
import java.util.List;

public class Example {
    public static void reverse(List<Integer> list) {
        int leftPointer = 0;
        int rightPointer = list.size() - 1;

        while (leftPointer <= rightPointer) {
            Collections.swap(list, leftPointer, rightPointer);

            leftPointer += 1;
            rightPointer -= 1;
        }
    }
}
