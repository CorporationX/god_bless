package faang.school.godbless.Lambdas.Calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        int productResult = product(numbers);
        System.out.println("Product: " + productResult);

        int sumResult = sum(numbers);
        System.out.println("Sum: " + sumResult);

    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
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

//  Этот блок я написал для себя, как подсказку на будущее, не обращайте внимания
//    Calculator<Integer> addition = (a, b) -> a + b;
//        System.out.println("Addition: " + addition.calculate(1, 5));
//
//                Calculator<Integer> subtraction = (a, b) -> a - b;
//        System.out.println("Subtraction: " + subtraction.calculate(10, 5));
//
//        Calculator<Integer> multiplication = (a, b) -> a * b;
//        System.out.println("Multiplication: " + multiplication.calculate(1, 5));
//
//        Calculator<Double> division = (a, b) -> {
//        if (b == 0) {
//        throw new ArithmeticException("Division by zero!");
//        }
//        return (double) a / b;
//        };
//        System.out.println("Division: " + division.calculate(30.0, 3.0));