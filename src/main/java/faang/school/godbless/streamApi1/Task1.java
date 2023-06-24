package faang.school.godbless.streamApi1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Найти сумму четных чисел в списке.
 * На вход получаем список чисел, на выходе должны получать int
 */
public class Task1 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(numbers);

        System.out.println(intStream.filter(n -> n % 2 == 0).sum()); //6
    }
}
