package faang.school.godbless.BJS2_21500;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        System.out.println(sum(nums));
        System.out.println(product(nums));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
