package faang.school.godbless.BJS2_21527;

import java.util.List;

public class Main {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        int result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculator(result, nums.get(i));
        }

        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, ((num1, num2) -> num1 * num2));
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, ((num1, num2) -> num1 + num2));
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7);

        System.out.println(sum(nums));
        System.out.println(product(nums));
    }
}
