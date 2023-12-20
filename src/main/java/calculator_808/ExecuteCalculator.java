package calculator_808;

import java.util.Arrays;
import java.util.List;

public class ExecuteCalculator {

    public static long calculate(List<Integer> nums, Calculator calculator) {

        if (nums.isEmpty()) throw new IllegalArgumentException("Не заполнены числа");

        int numResult = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            numResult = (int) calculator.calc(numResult, nums.get(i));
        }
        return numResult;
    }

    public static int product(List<Integer> nums) {
//        return calculate(nums, (value1, value2) -> Math.multiplyExact(value1, value2));
        return (int) calculate(nums, (value1, value2) -> value1 * value2);
    }

    public static int sum(List<Integer> nums) {
//        return calculate(nums, (value1, value2) -> Math.addExact(value1, value2));
        return (int) calculate(nums, (value1, value2) -> value1 + value2);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        System.out.println(sum(nums));
        System.out.println(product(nums));
    }
}