package faang.school.godbless.calculator;

import java.util.List;

public class Main {

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.apply(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static void main(String[] args) {
        var nums = List.of(2, 4, 6);

        var sum = sum(nums);
        System.out.println(sum);

        var product = product(nums);
        System.out.println(product);
    }
}
