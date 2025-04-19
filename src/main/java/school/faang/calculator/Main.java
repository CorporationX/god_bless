package school.faang.calculator;

import java.util.Arrays;
import java.util.List;

import static school.faang.calculator.Calculate.product;
import static school.faang.calculator.Calculate.sum;

public class Main {
    public static void main(String[] args) {
        List<Integer> resourceUsage = Arrays.asList(2, 4, 6, 8);
        int totalSum = sum(resourceUsage);
        System.out.printf("Сумма : %s%n", totalSum);
        int totalProduct = product(resourceUsage);
        System.out.printf("Произведение : %s%n", totalProduct);
    }
}