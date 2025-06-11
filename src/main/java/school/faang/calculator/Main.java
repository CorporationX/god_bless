package school.faang.calculator;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var sum = (Calculator<Integer>) Integer::sum;
        var product = (Calculator<Integer>) (a, b) -> a * b;

        var numbers = List.of(1, 2, 3, 4, 5);

        System.out.printf("Сумма чисел: %s%n", calculate(numbers, sum));
        System.out.printf("Произведение чисел: %s%n", calculate(numbers, product));
    }

    public static <T> T calculate(@NonNull List<T> nums, @NonNull Calculator<T> calculator) {
        return nums.stream().reduce(calculator).orElse(null);
    }
}
