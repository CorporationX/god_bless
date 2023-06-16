package faang.school.godbless.reverse;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        reverse(nums);
    }

    public static void reverse(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        System.out.println(nums);
        for (int i = nums.size() - 1; i >= 0; i--) {
            result.add(nums.get(i));
        }
        System.out.println(result);
    }
}
