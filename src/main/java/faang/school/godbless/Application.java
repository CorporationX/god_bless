package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String... args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        System.out.println(calculate(nums, (a,b)->b-a));
        System.out.println(sum(nums));
        System.out.println(product(nums));

    }

    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }
    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static int product(List<Integer> nums){
        return calculate(nums, (a, b) -> a * b);
    }


}
