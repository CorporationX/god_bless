package school.faang.bjs2_85493;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //null массивом
        int[] nums1 = null;
        int[] numsReverse1 = Example.reverse(nums1);
        System.out.println(Arrays.toString(numsReverse1));

        //массив в один символ
        int[] nums2 = {0};
        int[] numsReverse2 = Example.reverse(nums2);
        System.out.println(Arrays.toString(numsReverse2));

        //большой массив
        int[] nums3 = {1, 2, 3, 5, 6};
        int[] numsReverse3 = Example.reverse(nums3);
        System.out.println(Arrays.toString(numsReverse3));
    }
}