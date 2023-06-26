package faang.school.godbless.streamApi1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Найти максимальный элемент в списке чисел
 */
public class Task2 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(numbers);

        System.out.println(intStream.max().orElse(0));
    }
}
