package faang.school.godbless;

import java.util.List;

public class AppliedCalculator {
    public static int calculate(List<Integer> nums, Calculator<Integer, Integer, Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Wrong argumets");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.applyCalculate(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 3, 4, 5);
        System.out.println(product(list));
        System.out.println(sum(list));
    }
}
