public class Example {
    public static void reverse(int[] nums) {
        for(int i = 0; i < nums.length/2; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }
}
