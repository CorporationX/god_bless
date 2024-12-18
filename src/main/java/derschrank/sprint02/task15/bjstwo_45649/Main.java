package derschrank.sprint02.task15.bjstwo_45649;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2);
        System.out.println("We have list of numbers: " + numbers);

        CalculatorCenterInteger calc = new CalculatorCenterInteger();
        System.out.println("Make sum: " + calc.sum(numbers));
        System.out.println("Make product: " + calc.product(numbers));
    }
}
