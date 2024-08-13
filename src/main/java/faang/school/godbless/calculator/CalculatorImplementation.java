package faang.school.godbless.calculator;

import lombok.NonNull;

import java.util.List;

public class CalculatorImplementation {

    public static Number calculate(@NonNull List<? extends Number> numbers,
                                   @NonNull Calculator<Number> calculator) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List of numbers is empty");
        }
        if (!checkIfAllNumbersIsInstanceOfOneClass(numbers)) {
            throw new IllegalArgumentException("List of numbers have different class");
        }

        if (numbers.get(0) instanceof Integer) {
            List<Integer> integers = numbers.stream().map(number -> (Integer) number).toList();

            return integers.stream()
                    .skip(1)
                    .reduce(integers.get(0), (acc, number) -> calculator.calculate(acc, number).intValue());
        } else if (numbers.get(0) instanceof Double) {
            List<Double> integers = numbers.stream().map(number -> (Double) number).toList();

            return integers.stream()
                    .skip(1)
                    .reduce(integers.get(0), (acc, number) -> calculator.calculate(acc, number).doubleValue());

        } else if (numbers.get(0) instanceof Float) {
            List<Float> integers = numbers.stream().map(number -> (Float) number).toList();

            return integers.stream()
                    .skip(1)
                    .reduce(integers.get(0), (acc, number) -> calculator.calculate(acc, number).floatValue());
        } else if (numbers.get(0) instanceof Long) {
            List<Long> integers = numbers.stream().map(number -> (Long) number).toList();

            return integers.stream()
                    .skip(1)
                    .reduce(integers.get(0), (acc, number) -> calculator.calculate(acc, number).longValue());
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }

    public static Number product(List<Integer> nums) {
        return calculate(nums, (a, b) -> (Integer) a * (Integer) b);
    }

    public static Number sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> (Integer) a + (Integer) b);
    }

    private static boolean checkIfAllNumbersIsInstanceOfOneClass(List<?> numbers) {
        return numbers.size() == numbers.stream().filter(num -> num.getClass().equals(numbers.get(0).getClass())).count();
    }
}
