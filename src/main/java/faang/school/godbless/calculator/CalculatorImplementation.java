package faang.school.godbless.calculator;

import lombok.NonNull;

import java.util.List;

public class CalculatorImplementation<T extends Number> {

    public T calculate(@NonNull List<T> numbers,
                       @NonNull Calculator<T> calculator) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List of numbers is empty");
        }
        if (!checkIfAllNumbersIsInstanceOfOneClass(numbers)) {
            throw new IllegalArgumentException("List of numbers have different class");
        }

        checkIfAllElementsIsNumber(numbers);

        return numbers.stream()
                .skip(1)
                .reduce(numbers.get(0), calculator::calculate);
    }

    public Number productIntegers(List<T> nums) {
        Calculator<Number> mul = (a, b) -> {
            if (a instanceof Integer && b instanceof Integer) {
                return (Integer) a * (Integer) b;
            } else {
                throw new IllegalArgumentException("Unsupported number type");
            }
        };

        return calculate(nums, (Calculator<T>) mul);
    }

    public Number sumIntegers(List<T> nums) {
        Calculator<Number> sum = (a, b) -> {
            if (a instanceof Integer && b instanceof Integer) {
                return (Integer) a + (Integer) b;
            } else {
                throw new IllegalArgumentException("Unsupported number type");
            }
        };

        return calculate(nums, (Calculator<T>) sum);
    }

    private boolean checkIfAllNumbersIsInstanceOfOneClass(List<T> numbers) {
        return numbers.size() == numbers.stream().filter(num -> num.getClass().equals(numbers.get(0).getClass())).count();
    }

    private void checkIfAllElementsIsNumber(List<T> numbers) {
        if (!((numbers.get(0) instanceof Integer) ||
                (numbers.get(0) instanceof Double) ||
                (numbers.get(0) instanceof Float) ||
                (numbers.get(0) instanceof Long))) {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }
}
