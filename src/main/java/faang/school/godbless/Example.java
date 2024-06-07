package faang.school.godbless;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] reverseNums = reverse(nums);
        System.out.println(Arrays.toString(reverseNums));
    }
    public static int[] reverse(int[] nums){
        int[] result = new int[nums.length];
        int lastIndex = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[lastIndex-i];
        }
        return result;
    }
}
