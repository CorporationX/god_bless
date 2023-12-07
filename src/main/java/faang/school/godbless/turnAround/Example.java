package faang.school.godbless.turnAround;

public class Example {
    public static int[] reverse(int[] nums) {
        int index = nums.length - 1;
        int buble;
        for (int i = 0; i < nums.length / 2; i++) {
            buble = nums[i];
            nums[i] = nums[index];
            nums[index] = buble;
            index--;
        }
        return nums;
    }
}
