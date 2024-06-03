package BJS_7632;

import java.util.Arrays;

public class Example {

    public static void reverse(int[] arr) {
        int sizeArray = arr.length - 1;
        for (int i = 0; i < (int) Math.sqrt(arr.length); i++) {
            int temp = arr[i];
            arr[i] = arr[sizeArray - i];
            arr[sizeArray - i] = temp;
        }
        System.out.format("Reversed array: %s", Arrays.toString(arr));
    }
}