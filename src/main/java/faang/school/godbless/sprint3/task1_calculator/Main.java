package faang.school.godbless.sprint3.task1_calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        int ans = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            ans = calculator.add(ans, nums.get(i));
        }
        return ans;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> {
            return a + b;
        });
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> {
            return a * b;
        });
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(sum(nums));
        System.out.println(product(nums));
    }
}
