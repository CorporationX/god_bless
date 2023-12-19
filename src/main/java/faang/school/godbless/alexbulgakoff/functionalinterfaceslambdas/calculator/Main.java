package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.calculator;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(25, 94);

        System.out.println(product(numbers));
        System.out.println(sum(numbers));

    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        int result = 0;

        for (int i = 0; i < nums.size() - 1; i++) {
            result = calculator.calculate(nums.get(i), nums.get(i + 1));
        }

        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
