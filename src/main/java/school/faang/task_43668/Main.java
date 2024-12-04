package school.faang.task_43668;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};

        Example.reverse(nums1);
        Example.reverse(nums2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }
}
