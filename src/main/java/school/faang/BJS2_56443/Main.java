package school.faang.BJS2_56443;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int[] nums1 = {1, 2, 3, 4, 5};
        final int[] nums2 = {6};
        final int[] nums3 = {7, 8, 9, 10, 11, 12};
        final int[] nums4 = {};
        Example.reverse(nums1);
        System.out.println(Arrays.toString(nums1));

        Example.reverse(nums2);
        System.out.println(Arrays.toString(nums2));

        Example.reverse(nums3);
        System.out.println(Arrays.toString(nums3));

        Example.reverse(nums4);
        System.out.println(Arrays.toString(nums4));
    }
}
