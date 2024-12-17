package school.faang.task_45659;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        List<Integer> numbers = List.of(1, 2, 3, 4);

        int product = CalculatorUtils.product(numbers);
        int sum = CalculatorUtils.sum(numbers);

        System.out.println("Произведение: " + product);
        System.out.println("Сумма: " + sum);
    }

}
