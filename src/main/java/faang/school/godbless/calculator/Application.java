package faang.school.godbless.calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        product(nums);
    }

    public static int calculate(List<Integer> nums, Calculator calculator) {
        int result = nums.get(0);
        for (int i = 0; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, ((a, b) -> a + b));
    }

}
