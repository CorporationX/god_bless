package faang.school.godbless.streamApi1;

import java.util.Arrays;

/**
 * Найти наименьший элемент в списке, который больше заданного числа
 */
public class Task8 {
    public static void main(String[] args) {
        int[] integers = {8, 8, 6, 55, 3, 11, 5};

        System.out.println(Arrays.stream(integers).filter(i -> i > 8).min().orElse(0));
    }
}
