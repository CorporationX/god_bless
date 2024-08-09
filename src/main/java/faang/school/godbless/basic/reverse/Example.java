package faang.school.godbless.basic.reverse;

import java.util.Arrays;

public class Example {

    public static void reverse(int[] nums) {
        int[] newNums = Arrays.copyOf(nums, nums.length);;
        System.out.println("Original nums: " + Arrays.toString(nums));
        int count = newNums.length - 1;
        for (int i = 0 ;  i < newNums.length; i++) {
            int tmp = newNums[count];
            if (count == i) break;
            newNums[count] = newNums[i];
            newNums[i] = tmp;
            count--;
        }
        System.out.println("Reversed nums: " + Arrays.toString(newNums));
    }
}
