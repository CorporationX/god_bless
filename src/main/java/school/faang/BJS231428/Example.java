package school.faang.BJS231428;

public class Example {
    public static int[] reverse(int[] nums) {
        int count = nums.length - 1;
        for (int i = 0; i < nums.length/2; i++) {
            int currentNumber = nums[i];
            nums[i] = nums[count];
            nums[count] = currentNumber;
            count--;
        }
        return nums;
    }
}
