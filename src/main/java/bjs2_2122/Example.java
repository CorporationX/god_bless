package bjs2_2122;

public class Example {
    public static int[] reverse(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[nums.length - 1 - i];
        }
        return arr;
    }
}
