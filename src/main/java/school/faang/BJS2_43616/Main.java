package school.faang.BJS2_43616;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,7,8,9};

        System.out.println(Arrays.toString(nums));
        Example.reverse(nums);
        System.out.println(Arrays.toString(nums));
    }
}
