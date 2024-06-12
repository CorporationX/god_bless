package faang.school.godbless.kalculator;

import java.util.List;

public class CalculateList {
    private static int calculate(List<Integer> nums, Calculator calculator) {
        int buffer = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            buffer = calculator.interfaceCalculate(buffer, nums.get(i));
        }
        return buffer;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (s, h) -> s * h);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (s, h) -> s + h);
    }

}
