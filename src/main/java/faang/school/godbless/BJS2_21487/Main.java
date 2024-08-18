package faang.school.godbless.BJS2_21487;

import java.util.List;

public class Main {

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        int state = nums.get(0);
        for (int i = 0; i < nums.size() - 1; i++) {
            state = calculator.calculate(state, nums.get(i + 1));
        }
        return state;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (s, n) -> s * n);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (s, n) -> s + n);
    }
}
