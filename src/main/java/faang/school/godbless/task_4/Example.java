package faang.school.godbless.task_4;

import java.util.Arrays;
import java.util.Collections;

public class Example {
    public static void main(String[] args) {
        int[] numbers = new int[]{-15, 30, -45, -60, 75, 90, 105, 120, 135, 150};
        Integer[] secondNumbers = new Integer[]{-1, 2, -3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(secondNumbers));
        reverse(numbers);
        reverse(secondNumbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(secondNumbers));
    }

    public static void reverse(Integer[] numbers) {
        Collections.reverse(Arrays.asList(numbers));
    }

    public static void reverse(int[] numbers) {
        for (int i = 0, j = numbers.length - 1; i < numbers.length / 2; i++, j--) {
            int firstValue = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = firstValue;
        }
    }
}
