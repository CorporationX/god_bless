package school.faang.Grouping_users_by_age;

import java.util.Arrays;

public class Example {

    public static void reverse(int[] integers) {
        if (integers == null || integers.length <= 1) {
            System.out.println("массив пустой или имеет только один элемент");
            return;
        }
        int left = 0;
        int right = integers.length - 1;

        while (left < right) {
            int temp = integers[left];
            integers[left] = integers[right];
            integers[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(integers));
    }
}
