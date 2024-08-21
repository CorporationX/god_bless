package faang.school.godbless.bjs221615;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CalculatorApp calculator = new CalculatorApp();
        List<Double> numbers = List.of(32.0, 4.0, 2.0);

        System.out.println(calculator.add(numbers));
        System.out.println(calculator.substract(numbers));
        System.out.println(calculator.divide(numbers));
        System.out.println(calculator.multiply(numbers));
    }
}