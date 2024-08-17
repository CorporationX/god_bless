package faang.school.godbless.BJS2_21600;

import java.util.Arrays;
import java.util.List;

public class CalculatorClass {
    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calc(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return CalculatorClass.calculate(nums, (integer, integer2) -> integer * integer2);
    }

    public static int sum(List<Integer> nums) {
        return CalculatorClass.calculate(nums, (integer, integer2) -> integer + integer2);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sumResult = CalculatorClass.sum(numbers);
        System.out.println("Сумма всех чисел: " + sumResult);

        int productResult = CalculatorClass.product(numbers);
        System.out.println("Произведение всех чисел: " + productResult);
    }
}
