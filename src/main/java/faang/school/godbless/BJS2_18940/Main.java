package faang.school.godbless.BJS2_18940;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;

        int[] reversed = Example.reverse(nums);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(reversed));
    }
}
