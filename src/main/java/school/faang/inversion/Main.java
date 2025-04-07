package school.faang.inversion;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] reversedNumbers = reverse(numbers);

        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(reversedNumbers));
    }

    private static int[] reverse(int[] numbers) {
        final int length = numbers.length;
        final int[] inversionNumbers = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            inversionNumbers[length - i - 1] = numbers[i];
        }

        return inversionNumbers;
    }
}
