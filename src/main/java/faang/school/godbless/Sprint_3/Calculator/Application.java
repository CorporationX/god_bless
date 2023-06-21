package faang.school.godbless.Sprint_3.Calculator;

import java.util.List;

public class Application {

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        int res = 1;
        for(int x : nums) {
            res = calculator.operate(res, x);
        }
        return res;
    }

    public static int product(List<Integer> nums) {
        Calculator productCalculator = (int a, int b) -> a * b;
        return calculate(nums, productCalculator);
    }

    public static int sum(List<Integer> nums) {
        Calculator productCalculator = (int a, int b) -> a + b;
        return calculate(nums, productCalculator) - 1;
    }

}
