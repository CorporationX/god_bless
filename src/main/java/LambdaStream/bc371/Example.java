package LambdaStream.bc371;

public class Example {

    public int[] reverse(int[] nums) {
        if (nums == null) {
            System.out.println("array cannot be null");
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }
}
