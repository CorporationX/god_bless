package faang.school.godbless.BJS2_4585;

public class Example {

    public static void reverse(int[] nums) {
        int arrayLength = nums.length;
        int[] arrayTemp = new int[arrayLength];
        for (int i = 0; i < nums.length; i++) {
            arrayTemp[i] = nums[(arrayLength - 1) - i];
            nums[i] = arrayTemp[i];
        }
    }

}