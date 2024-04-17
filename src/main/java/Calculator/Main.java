package Calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(product(nums));
        System.out.println(sum(nums));
    }

    private static long calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        long result = nums.get(0);
        for (int i = 0; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    private static long product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    private static long sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }
}
