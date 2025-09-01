package school.faang;

import java.util.Arrays;

public class Example {

    private static final int[] NUMBERS = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        int[] numbersReversed = reverse(NUMBERS);

        System.out.println(Arrays.toString(numbersReversed));
    }

    private static int[] reverse(int[] numbers) {
        int[] numbersReversed = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numbersReversed[i] = numbers[numbers.length - 1 - i];
        }
        return numbersReversed;
    }
}
