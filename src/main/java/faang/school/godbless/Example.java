package faang.school.godbless;

public class Example {
    public void reverse(int[] nums) {
        for (int i = 0; i < nums.length/2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length-i -1] = temp;
        }
    }
}
