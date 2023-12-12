package faang.school.godbless.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static Calculator calculatorMult = (a, b) -> a * b;
    public static Calculator calculatorSum = (a, b) -> a + b;

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(product(nums));
        System.out.println(sum(nums));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.action(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, calculatorMult);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, calculatorSum);
    }
}
