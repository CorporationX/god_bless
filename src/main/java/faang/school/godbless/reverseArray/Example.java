package faang.school.godbless.reverseArray;

import java.util.Arrays;

public class Example {
    public static int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
    public static void main(String[] args) {
        //четное число элементов
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //нечетное число элементов
        int[] nums2 = {1, 2, 3, 4, 5};

        int[] result1 = reverse(nums2);
        int[] result2 = reverse(nums1);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}
