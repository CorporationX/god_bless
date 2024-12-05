package school.faang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(reverse(nums)));
    }

    public static int[] reverse(int[] nums) {
        int[] reversed = new int[nums.length];
        int i = 0;
        for (int j = nums.length-1; j >= 0; j--) {
            reversed[i] = nums[j];
            i++;
        }
        return reversed;
    }
}
