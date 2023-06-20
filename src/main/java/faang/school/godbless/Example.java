package faang.school.godbless;

import java.util.Arrays;
import java.util.Collections;

public class Example {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        reverse(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void reverse(Integer[] nums) {
        Collections.reverse(Arrays.asList(nums));
    }
}
