package faang.school.godbless.calculator;

import java.util.*;

public class Calc {

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        Integer result = 1;
        for (int i = 0; i < nums.size(); i++) {
            result = calculator.calculate(nums.get(i), result);
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        Calculator multiplication = (first, second) -> first * second;
        return calculate(nums, multiplication);
    }

    public static int sum(List<Integer> nums) {
        Calculator addition = (first, second) -> first + second;
        return calculate(nums, addition) - 1;
    }
}
