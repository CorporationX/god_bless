package faang.school.godbless.array;

import java.util.Arrays;

public class Example {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(reverse(nums)));
    }

    public static int[] reverse(int[] arr) {
        int[] reversedArray = new int[arr.length];
        for (int i = 0; i < reversedArray.length; i++) {
            reversedArray[i] = arr[arr.length - 1 - i];
        }
        return reversedArray;
    }
}
