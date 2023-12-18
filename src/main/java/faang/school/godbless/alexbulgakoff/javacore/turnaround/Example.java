package faang.school.godbless.alexbulgakoff.javacore.turnaround;

import java.util.Arrays;

/**
 * @author Alexander Bulgakov
 */
public class Example {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        int[] arr3 = {1, 2, 3, 4, 65};

        System.out.println(Arrays.toString(reverse(arr1)));
        System.out.println(Arrays.toString(reverse(arr2)));
        System.out.println(Arrays.toString(reverse(arr3)));
    }

    public  static int[] reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }
}
