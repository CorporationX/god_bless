package school.faang;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] arr) {
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

    public static void main(String[] args) {
        int[] arr = {53, 2, 6, 9, 12};
        System.out.println("Array before reverse" + Arrays.toString(arr));
        reverse(arr);
        System.out.println("Array after reverse" + Arrays.toString(arr));
    }
}