package school.faang.reverse;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] arr) {

        if (arr == null || arr.length == 0) {
            System.out.println("The array is either null or empty.");
        } else {
            int start = 0;
            int end = arr.length - 1;
            int tmp;

            while (start < end) {
                tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
        }
    }
}