package BJS2_56425;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {};
        int[] nums3 = null;
        int[] nums4 = {1};

        int[] reversed1 = Example.reverse(nums1);
        int[] reversed2 = Example.reverse(nums2);
        int[] reversed3 = Example.reverse(nums3);
        int[] reversed4 = Example.reverse(nums4);

        System.out.println(Arrays.toString(reversed1));
        System.out.println(Arrays.toString(reversed2));
        System.out.println(Arrays.toString(reversed3));
        System.out.println(Arrays.toString(reversed4));
    }
}
