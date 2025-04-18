package school.faang.bjs2_69339;

import java.util.Collections;
import java.util.List;

public class Example {
    public static void reverseNaive(List<Integer> nums) {
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            var removedNum = nums.remove(j);
            nums.add(i, removedNum);

            i++;
        }
    }

    public static void reverse(List<Integer> nums) {
        Collections.reverse(nums);
    }
}