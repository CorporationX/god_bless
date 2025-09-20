package school.faang.bjs2_90999;

import java.util.Arrays;
import java.util.List;
import static school.faang.bjs2_90999.CalculationUtils.*; // ВАЖНО: статический импорт

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        System.out.println("Числа: " + numbers);
        System.out.println("Сумма: " + calculate(numbers, Integer::sum));
        System.out.println("Произведение: " + calculate(numbers, (a, b) -> a * b));
        System.out.println("Максимум: " + calculate(numbers, Math::max));

        System.out.println("sum(): " + sum(numbers));
        System.out.println("product(): " + product(numbers));

        try {
            sum(Arrays.asList());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}