package school.faang.sprint_2.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> data = List.of(2, 3, 4);

        System.out.println("Сумма: " + CalculatorManager.sum(data));       // 9
        System.out.println("Произведение: " + CalculatorManager.product(data)); // 24
    }
}
