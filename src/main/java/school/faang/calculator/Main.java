package school.faang.calculator;

import java.util.List;

import static school.faang.calculator.CalculateProcess.product;
import static school.faang.calculator.CalculateProcess.sum;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        int sumResult = sum(numbers);
        int productResult = product(numbers);

        System.out.println("Сумма: " + sumResult);
        System.out.println("Произведение: " + productResult);
    }
}
