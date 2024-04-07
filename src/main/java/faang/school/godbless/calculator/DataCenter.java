package faang.school.godbless.calculator;

import java.util.List;

public class DataCenter {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        System.out.println("sum, expected 15");
        System.out.println(sum(nums));
        System.out.println();

        System.out.println("product, expected 120");
        System.out.println(product(nums));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (first, second) -> first * second);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
