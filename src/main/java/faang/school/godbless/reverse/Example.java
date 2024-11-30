package faang.school.godbless.reverse;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        reverse(numbers);

        System.out.println("reverse array ---> " + Arrays.toString(numbers));
    }
}
