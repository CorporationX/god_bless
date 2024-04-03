package task;

public class Example {

    public static void reverse(int[] nums) {
        int tmp;
        for (int i = 0; i < (nums.length / 2); i++) {
            tmp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        reverse(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
