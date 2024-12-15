package school.faang.bjs_43645;

public class NumsUtils {

    public void reverse(int[] nums) {
        int numsCount = nums.length;
        for (int i = 0; i < numsCount / 2; i++) {
            int tempNum = nums[i];
            nums[i] = nums[numsCount - i - 1];
            nums[numsCount - i - 1] = tempNum;
        }
    }
}
