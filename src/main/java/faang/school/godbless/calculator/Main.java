package faang.school.godbless.calculator;

import lombok.NonNull;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sumResult = add(numbers);
        int productResult = multiply(numbers);

        System.out.println("Sum: " + sumResult);
        System.out.println("Product: " + productResult);
    }

    static int calculate(@NonNull List<Integer> nums, Calculator<Integer> calculator) {
        int result = nums.get(0);

        for (int index = 1; index < nums.size(); index++) {
            result = calculator.solve(result, nums.get(index));
        }
        return result;
    }

    public static int add(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    static int subtract(List<Integer> nums) {
        return calculate(nums, (a, b) -> a - b);
    }

    static int multiply(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
