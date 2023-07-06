package faang.school.godbless.sprint3_lambda.calculate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        Calculator calculator = ((param1, param2) -> param1 + param2);
        System.out.println(calculate(nums, calculator));
        System.out.println(product(nums));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("numbers list is empty");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.apply(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        Calculator calculator = (a, b) -> a * b;
        return calculate(nums, calculator);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }
}