package derschrank.sprint02.task15.bjstwo_45649;

import java.util.List;

public class CalculatorCenterInteger {

    public Integer sum(List<Integer> numbers) throws IllegalArgumentException {
        Calculator<Integer> sum = Integer::sum;
        return sum.calculate(numbers);
    }

    public Integer product(List<Integer> numbers) throws IllegalArgumentException {
        Calculator<Integer> producer = (a, b) -> a * b;
        return producer.calculate(numbers);
    }

}
