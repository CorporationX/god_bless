package faang.school.godbless.BJS2_21470;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(CalculatorService.product(numbers));
        System.out.println(CalculatorService.sum(numbers));
        System.out.println(CalculatorService.calculate(numbers, (nums) ->
                nums.stream().max(Comparator.naturalOrder()).orElse(-1)));
    }
}
