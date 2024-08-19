package com.functional.calculator;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CalculatorUntil {

    public static int calculate(List<Integer> numbers, Calculator calculator) {
        if (numbers.isEmpty()) {
            return 0;
        }
        int total = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {

            total = calculator.calculation(total, numbers.get(i));
        }
        return total;
    }

    public static int sum(List<Integer> numbers) {
        return calculate(numbers, Integer::sum);
    }

    public static long product(List<Integer> numbers) {
        return calculate(numbers, (total, numberTwo) -> total *= numberTwo);
    }
}
