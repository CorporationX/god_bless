package faang.school.godbless.calculator;

import java.util.List;

import static faang.school.godbless.calculator.CalculatorImplementation.*;

public class Main {

    public static void main(String[] args) {
        Calculator<Integer> summ = (a, b) -> a + b;
        Calculator<Integer> sub = (a, b) -> a - b;
        Calculator<Integer> mul = (a, b) -> a * b;
        Calculator<Integer> div = (a, b) -> a / b;

        List<Integer> integers = List.of(1, 2, 3, 4);

        System.out.println(calculate(integers, summ));
        System.out.println(calculate(integers, sub));
        System.out.println(calculate(integers, mul));
        System.out.println(calculate(integers, div));
        System.out.println(sum(integers));
        System.out.println(product(integers));

    }
}
