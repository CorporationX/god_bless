package faang.school.godbless.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(product(nums));
        System.out.println(sum(nums));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        int result = 1;
        for (Integer num : nums) {
            result = calculator.function(result, num);
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b) - 1;
    }

}
