public class Example {
    public static void main(String[] args) {

    }

    public int[] reverse(int[] nums) {
        if (nums == null) {
            throw new NullPointerException();
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
