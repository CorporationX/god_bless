package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.calculator;

import java.util.List;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    public static void main(String[] args) {

    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        int result = 0;

        for (Integer num : nums) {
            result = calculator.calculate(num, nums.lastIndexOf(num));
        }

        return result;
    }
}
