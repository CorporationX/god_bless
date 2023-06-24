package faang.school.godbless.streamApi2;

import java.util.Arrays;

/**
 * Написать метод, который преобразует список целых чисел в список строк,
 * где каждое число записано в двоичном виде.
 */
public class Task7 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        System.out.println(Arrays.stream(numbers).mapToObj(Integer::toBinaryString).map(String::toString).toList());
    }
}
