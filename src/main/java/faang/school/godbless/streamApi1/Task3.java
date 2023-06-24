package faang.school.godbless.streamApi1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Найти среднее значение чисел в списке
 */
public class Task3 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(numbers);

        System.out.println(intStream.average().orElse(0));
    }
}
