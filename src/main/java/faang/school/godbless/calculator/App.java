package faang.school.godbless.calculator;

import java.util.List;

public class App {

    public static int calculate(List<Integer> digits, Calculator calculator) {
        if (digits.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        if (digits == null || calculator == null) {
            throw new IllegalArgumentException("null argument");
        }
        int result = digits.get(0);
        for (int i = 1; i < digits.size(); ++i) {
            result = calculator.calculate(result, digits.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> digits) {
        return calculate(digits, (a, b) -> a + b);
    }

    public static int product(List<Integer> digits) {
        return calculate(digits, (a, b) -> a * b);
    }

}
