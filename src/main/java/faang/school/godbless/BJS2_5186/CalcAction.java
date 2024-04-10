package faang.school.godbless.BJS2_5186;

import java.util.List;

public class CalcAction {
    public static int calculate(List<Integer> numbers, Calculator calculator) {
        return numbers.stream().reduce(calculator::calculate)
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static int product(List<Integer> numbers){
        return calculate(numbers, ((firstNumb, secondNumb) -> firstNumb * secondNumb));
    }

    public static int sum(List<Integer> numbers){
        return calculate(numbers, Integer::sum);
    }
}
