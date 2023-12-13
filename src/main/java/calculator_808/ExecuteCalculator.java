package calculator_808;

import java.util.Arrays;
import java.util.List;

public class ExecuteCalculator {

    public static int calculate(List<Integer> nums, Calculator calculator) {
        int numResult = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            numResult = calculator.calc(numResult, nums.get(i));
        }
        return numResult;
    }

    public static int product(List<Integer> nums) {
        Calculator multiplying = (value1, value2) -> value1 * value2;
        return calculate(nums, multiplying);
    }

    public static int sum(List<Integer> nums) {
        Calculator sum = (value1, value2) -> value1 + value2;
        return calculate(nums, sum);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 5, 10, 15);
        System.out.println(sum(nums));
        System.out.println(product(nums));
    }
}