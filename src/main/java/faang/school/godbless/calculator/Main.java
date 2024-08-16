package faang.school.godbless.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CalculatorImplementation calculator = new CalculatorImplementation();

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(calculator.productIntegers(numbers));
        System.out.println(calculator.sumIntegers(numbers));

        Number number = 1;
        Number number2 = 2;
        Number number3 = 3;
        Number number4 = 4;
        Number number5 = 5;
        List<Number> intNumbers = List.of(number, number2, number3, number4, number5);

        Calculator<Number> summarize = (a, b) -> {
            if (a instanceof Integer && b instanceof Integer) {
                return (Integer) a + (Integer) b;
            } else if (a instanceof Double && b instanceof Double) {
                return (Double) a + (Double) b;
            } else if (a instanceof Float && b instanceof Float) {
                return (Float) a + (Float) b;
            } else if (a instanceof Long && b instanceof Long) {
                return (Long) a + (Long) b;
            } else {
                throw new IllegalArgumentException("Unsupported number type");
            }
        };

        Calculator<Number> subtraction = (a, b) -> {
            if (a instanceof Integer && b instanceof Integer) {
                return (Integer) a - (Integer) b;
            } else if (a instanceof Double && b instanceof Double) {
                return (Double) a - (Double) b;
            } else if (a instanceof Float && b instanceof Float) {
                return (Float) a - (Float) b;
            } else if (a instanceof Long && b instanceof Long) {
                return (Long) a - (Long) b;
            } else {
                throw new IllegalArgumentException("Unsupported number type");
            }
        };

        Calculator<Number> multiply = (a, b) -> {
            if (a instanceof Integer && b instanceof Integer) {
                return (Integer) a * (Integer) b;
            } else if (a instanceof Double && b instanceof Double) {
                return (Double) a * (Double) b;
            } else if (a instanceof Float && b instanceof Float) {
                return (Float) a * (Float) b;
            } else if (a instanceof Long && b instanceof Long) {
                return (Long) a * (Long) b;
            } else {
                throw new IllegalArgumentException("Unsupported number type");
            }
        };

        Calculator<Number> divide = (a, b) -> {
            if (a instanceof Integer && b instanceof Integer) {
                return (Integer) a / (Integer) b;
            } else if (a instanceof Double && b instanceof Double) {
                return (Double) a / (Double) b;
            } else if (a instanceof Float && b instanceof Float) {
                return (Float) a / (Float) b;
            } else if (a instanceof Long && b instanceof Long) {
                return (Long) a / (Long) b;
            } else {
                throw new IllegalArgumentException("Unsupported number type");
            }
        };

        System.out.println(calculator.calculate(intNumbers, summarize));
        System.out.println(calculator.calculate(intNumbers, subtraction));
        System.out.println(calculator.calculate(intNumbers, multiply));
        System.out.println(calculator.calculate(intNumbers, divide));

        number = 1f;
        number2 = 2f;
        number3 = 3f;
        List<Number> floatNumbers = List.of(number, number2, number3);
        System.out.println(calculator.calculate(floatNumbers, summarize));
        System.out.println(calculator.calculate(floatNumbers, subtraction));
        System.out.println(calculator.calculate(floatNumbers, multiply));
        System.out.println(calculator.calculate(floatNumbers, divide));
    }
}
