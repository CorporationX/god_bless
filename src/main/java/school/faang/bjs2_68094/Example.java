package school.faang.bjs2_68094;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reverse(numbers)));
    }

    public static int[] reverse(int[] nums) {
        int[] reversedArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            reversedArray[i] = nums[nums.length - 1 - i];
        }
        return reversedArray;
    }
}
