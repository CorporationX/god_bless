package faang.school.godbless.Task_Calculator;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class Calculate {

    public double calculate(List<Double> numbers, Calculator calculator) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        } else {
            double res = numbers.get(0);
            for (int i = 1; i < numbers.size(); i++) {
                res = calculator.calculate(res, numbers.get(i));
            }
            return res;
        }
    }

    public double sum(List<Double> numbers) {
        return calculate(numbers, (a, b) -> a + b);
    }

    public double prod(List<Double> numbers) {
        return calculate(numbers, (a, b) -> a * b);
    }

}
