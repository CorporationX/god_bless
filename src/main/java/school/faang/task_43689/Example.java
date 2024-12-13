package school.faang.task_43689;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example {

    public static void reverse(Integer[] nums) {
        List<Integer> originalNums = Arrays.asList(nums);
        Collections.reverse(originalNums);
        originalNums.toArray(new Integer[0]);


    }
}
