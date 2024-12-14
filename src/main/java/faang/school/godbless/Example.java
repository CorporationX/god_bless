package faang.school.godbless;

import java.sql.SQLOutput;
import java.util.*;

public class Example {

    public static int[] reverse(int[] array) {

        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Массив перед ревёрсом");

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " ");
        }
        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }
        System.out.println("Массив после ревёрса");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " ");
        }
        return numbers;
    }
}
