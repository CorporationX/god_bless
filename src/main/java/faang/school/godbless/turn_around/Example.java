package faang.school.godbless.turn_around;

import java.util.Arrays;

public class Example {

    public static void reverse(int[] numbers) {
        int[] newArray = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            newArray[numbers.length - 1 - i] = numbers[i];
        }
        System.out.println(Arrays.toString(newArray));
    }
}
