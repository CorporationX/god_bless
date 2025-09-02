package school.faang.BJS2_85447;

import java.util.Arrays;

public class Example {

    private static final int[] NUMBERS = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        int[] numbersReversed = reverse(NUMBERS);

        System.out.println(Arrays.toString(numbersReversed));
    }

    private static int[] reverse(int[] numbers) {
        if (numbers == null) {
            return numbers;
        }

        int temp;
        for (int i = 0; i < numbers.length / 2; i++) {
            temp = numbers[numbers.length - i - 1];
            numbers[numbers.length - i - 1] = numbers[i];
            numbers[i] = temp;
        }

        return numbers;
    }
}
