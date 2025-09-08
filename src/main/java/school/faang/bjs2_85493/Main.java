package school.faang.bjs2_85493;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Example arr1 = new Example();

        //пример с null массивом
        int[] nums1 = null;
        int[] numsReverse1 = arr1.reverse(nums1);
        System.out.println(Arrays.toString(numsReverse1));

        //пример с массивом в один символ
        int[] nums2 = {0};
        int[] numsReverse2 = arr1.reverse(nums2);
        System.out.println(Arrays.toString(numsReverse2));

        //пример с большим массивом
        int[] nums3 = {1, 2, 3, 5, 2};
        int[] numsReverse3 = arr1.reverse(nums3);
        System.out.println(Arrays.toString(numsReverse3));
    }
}
