package faang.school.godbless.bjs2_21427;

import java.util.List;

public class Main {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.size() < 2) {
            throw new IllegalArgumentException();
        }

        int result = nums.get(0);
        int last = nums.size() - 1;
        for (int i = 1; i <= last; i++) {
            result = calculator.execute(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        if (nums.size() == 1) {
            return nums.get(0);
        }
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        if (nums.size() == 1) {
            return nums.get(0);
        }
        return calculate(nums, Integer::sum);
    }
}
