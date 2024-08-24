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

        return numbers.stream()
                .skip(1)
                .reduce(numbers.get(0), calculator::calculate);
    }

    public Number productIntegers(List<Integer> nums) {
        Calculator<Integer> mul = (a, b) -> a * b;

        return calculate((List<T>) nums, (Calculator<T>) mul);
    }

    public Number sumIntegers(List<Integer> nums) {
        Calculator<Integer> sum = Integer::sum;

        return calculate((List<T>) nums, (Calculator<T>) sum);
    }

    private boolean checkIfAllNumbersIsInstanceOfOneClass(List<T> numbers) {
        return numbers.size() == numbers.stream().filter(num -> num.getClass().equals(numbers.get(0).getClass())).count();
    }
}
