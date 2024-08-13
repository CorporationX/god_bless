package faang.school.godbless.calculator;

import lombok.NonNull;

import java.util.List;

public class CalculatorImplementation {

    public static int calculate(@NonNull List<Integer> numbers,
                                @NonNull Calculator<Integer> calculator) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List of numbers is empty");
        }

        int res = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            res = calculator.calculate(res, numbers.get(i));
        }

        return res;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
