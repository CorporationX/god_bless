package faang.school.godbless.BJS2_21451;

import java.util.List;

public class Main {

    private static <T extends Number> T calculate(List<T> nums, Calculator<T> calculator) {
        T result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.apply(result, nums.get(i));
        }
        return result;
    }

    public static Integer product(List<Integer> nums) {
        return calculate(nums, (x, y) -> x * y);
    }

    public static Integer sum(List<Integer> nums) {
        return calculate(nums, (x, y) -> x + y);
    }
}
