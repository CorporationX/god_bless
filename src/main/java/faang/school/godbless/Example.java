package faang.school.godbless;

import java.util.Arrays;

public class Example {
    public static int[] reverse(int[] numbers) {
        for (int i = 0; i < numbers.length/2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length- i-1];
            numbers[numbers.length- i-1] = temp;
        }

        return numbers;
    }
}
