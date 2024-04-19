package faang.school.godbless.calculators;

import java.util.List;

import static faang.school.godbless.calculators.CalculatorService.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);

        System.out.println(product(numbers));
        System.out.println(sum(numbers));
    }
}
