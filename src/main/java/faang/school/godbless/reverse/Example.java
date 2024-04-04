package faang.school.godbless.reverse;

import java.util.Arrays;
import java.util.Collections;

public class Example {
    public static void reverse(Integer[] nums) {
        Collections.reverse(Arrays.asList(nums));
        System.out.println(Arrays.toString(nums));
    }
}

