package school.faangSprint2.t14;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CalculatorImplementation calc = new CalculatorImplementation();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        try {
            System.out.println("Sum: " + calc.sum(numbers));
            System.out.println("Product: " + calc.product(numbers));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}