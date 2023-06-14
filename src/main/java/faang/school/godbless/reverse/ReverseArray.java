package faang.school.godbless.reverse;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(reverse(numbers)));

    }

    public static int[] reverse(int[] ints) {
        int[] reverseNumbers = new int[ints.length];
        for (int i = 0; i < reverseNumbers.length; i++) {
            reverseNumbers[reverseNumbers.length - i - 1] = ints[i];
        }
        return reverseNumbers;
    }
}
