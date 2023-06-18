package faang.school.godbless.calculator;

import java.util.List;

public class CalculatorService {
    public static long sum(List<Integer> digits) {
        return CalculatorService.calculate(digits, Integer::sum);
    }

    public static long multiply(List<Integer> digits) {
        return CalculatorService.calculate(digits, (a, b) -> a * b);
    }

    private static long calculate(List<Integer> digits, Calculator<Integer> calculator) {
        if (digits.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = digits.get(0);
        for (int i = 1; i < digits.size(); ++i) {
            result = calculator.action(result, digits.get(i));
        }
        return result;
    }
}
