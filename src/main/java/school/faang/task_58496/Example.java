package school.faang.task_58496;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] testArray1 = {1, 2, 3, 4, 5};
        reverse(testArray1);
        System.out.println("Odd-length array reversed: " + Arrays.toString(testArray1));

        int[] testArray2 = {1, 2, 3, 4};
        reverse(testArray2);
        System.out.println("Even-length array reversed: " + Arrays.toString(testArray2));

        int[] testArray3 = {42};
        reverse(testArray3);
        System.out.println("Single-element array reversed: " + Arrays.toString(testArray3));

        int[] testArray4 = {};
        reverse(testArray4);

        int[] testArray5 = {-1, -2, -3, -4, -5};
        reverse(testArray5);
        System.out.println("Array with negative numbers reversed: " + Arrays.toString(testArray5));

        int[] testArray6 = {1, 2, 2, 1};
        reverse(testArray6);
        System.out.println("Array with duplicate elements reversed: " + Arrays.toString(testArray6));
    }

    /**
     * Reverses the given array.
     *
     * @param numbers the array to be reversed
     */
    public static void reverse(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("Array is null or empty, no reversal performed.");
            return;
        }

        int left = 0;
        int right = numbers.length - 1;
        int tempValue;

        for (int i = 0; i < numbers.length / 2; i++) {
            tempValue = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = tempValue;
            left++;
            right--;
        }
    }
}

