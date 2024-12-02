package school.faang.task_43625;

import java.util.Arrays;

public class Example {

    public static void main(String[] args) {
        int[] reverse = reverse(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(reverse));
    }

    public static int[] reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return arr;
    }
}
