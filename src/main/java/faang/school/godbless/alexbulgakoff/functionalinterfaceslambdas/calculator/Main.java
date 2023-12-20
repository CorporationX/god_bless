package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(25, 94);
        List<Integer> numbersEmpty = new ArrayList<>();

        System.out.println(product(numbers));
        System.out.println(sum(numbers));

        System.out.println(sum(numbersEmpty));

    }

    public static long calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        long result = 0;

        for (int i = 0; i < nums.size() - 1; i++) {
            result = calculator.calculate(nums.get(i), nums.get(i + 1));
        }

        return result;
    }

    public static int product(List<Integer> nums) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("In list not arguments");
        }
        return (int) calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("In list not arguments");
        }
        return (int) calculate(nums, Integer::sum);
    }
}
