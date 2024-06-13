package faang.school.godbless.lambdas.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 5);

        System.out.println(sum(nums));
        System.out.println(product(nums));
    }

    public static Integer calculate(List<Integer> nums, Calculator calculator) {
        if (nums == null || nums.isEmpty()
                || calculator == null) {
            throw new IllegalArgumentException();
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.apply(result, nums.get(i));
        }
        return result;
    }

    public static Integer sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static Integer product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
