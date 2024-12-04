package ru.maks1979.ArrayReverse;

import java.util.Arrays;

public class Example {
    public static int[] reverse (int[]nums) {
        for (int i = 0; i < nums.length/2; i++) {
         int temp = nums [i];
            nums [i] = nums [nums.length-1-i];
            nums[nums.length-1-i] = temp;
        }
        return nums;
    }


    public static void main(String[] args) {
        int [] testArray;
        testArray = new int[]{1, 2, 3, 4, 5, 6, 7,9,11};
        System.out.println(Arrays.toString(reverse(testArray)));
    }
}
