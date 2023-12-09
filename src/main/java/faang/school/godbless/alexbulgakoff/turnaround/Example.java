package faang.school.godbless.alexbulgakoff.turnaround;

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
        int[] temp = new int[arr.length];

        for (int i = arr.length - 1; i > 0;) {
            for (int j = 0; j < arr.length; j++) {
                temp[j] = arr[i];
                i--;
            }
        }
        return temp;
    }
}
