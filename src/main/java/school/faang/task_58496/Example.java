package school.faang.task_58496;

import java.util.Arrays;

public class Example {

    public static void main(String[] args) {

        int[] testArray = {1, 2, 3, 4, 5};
        reverse(testArray);
        System.out.println(Arrays.toString(testArray));

    }

    public static void reverse(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int temp;

        for (int i = 0; i < numbers.length / 2; i++) {
            temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }

    }
}
