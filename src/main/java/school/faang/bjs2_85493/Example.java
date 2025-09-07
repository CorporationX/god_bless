package school.faang.bjs2_85493;

public class Example {
    public int[] reverse(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return nums;
    }
}
