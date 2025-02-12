package school.faang.calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Сумма: " + sum(numbers)); // Вывод: Сумма: 15
        System.out.println("Произведение чисел: " + product(numbers)); // Вывод: Произведение: 120
    }

    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Список чисел не должен быть пустым");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.metod(result, nums.get(i));
        }
        return result;
    }

    // Метод для вычисления произведения всех чисел в списке
    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }
}