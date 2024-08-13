package faang.school.godbless.calculator;

import java.util.List;

import static faang.school.godbless.calculator.CalculatorImplementation.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(product(numbers));
        System.out.println(sum(numbers));

        Number number = 1;
        Number number2 = 2;
        Number number3 = 3;
        Number number4 = 4;
        Number number5 = 5;
        List<Number> intNumbers = List.of(number, number2, number3, number4, number5);

        Calculator<Number> sum = (a, b) -> {
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

        Calculator<Number> sub = (a, b) -> {
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

        Calculator<Number> mul = (a, b) -> {
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

        Calculator<Number> div = (a, b) -> {
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

        System.out.println(calculate(intNumbers, sum));
        System.out.println(calculate(intNumbers, sub));
        System.out.println(calculate(intNumbers, mul));
        System.out.println(calculate(intNumbers, div));

        number = 1f;
        number2 = 2f;
        number3 = 3f;
        List<Number> floatNumbers = List.of(number, number2, number3);
        System.out.println(calculate(floatNumbers, sum));
        System.out.println(calculate(floatNumbers, sub));
        System.out.println(calculate(floatNumbers, mul));
        System.out.println(calculate(floatNumbers, div));
    }
}
