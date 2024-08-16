package faang.school.godbless;

import faang.school.godbless.Calculator.Calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(product(List.of(5,4,2)));
        System.out.println(sum(List.of(5,4,2)));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("The list cannot be null or empty");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.apply(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
