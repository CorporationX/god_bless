package faang.school.godbless.BJS28999;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);
        System.out.println("Sum: " + sum(nums));
        System.out.println("Product: " + product(nums));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("List can't be null or empty!");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (x, y) -> x + y);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (x, y) -> x * y);
    }

}
