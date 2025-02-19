package school.faang.BJS2_57152;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CalculatorLogic logic = new CalculatorLogic();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.printf("Произведение всех чисел = %d\n", logic.product(numbers));
        System.out.printf("Сумма всех чисел = %d\n", logic.sum(numbers));
    }
}
