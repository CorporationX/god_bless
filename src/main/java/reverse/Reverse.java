package reverse;

import java.util.Arrays;

public class Reverse {
    public static void reverse(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;

        while (head < tail) {
            swap(nums, head, tail);
            head++;
            tail--;
        }
    }

    private static void swap(int[] nums, int head, int tail) {
        int temp = nums[head];
        nums[head] = nums[tail];
        nums[tail] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
}
