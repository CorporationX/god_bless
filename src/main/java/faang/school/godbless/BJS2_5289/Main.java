package faang.school.godbless.BJS2_5289;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(product(nums));
        System.out.println(sum(nums));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Integer result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.doOperation(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
