package faang.school.godbless.BJS2_4121;

public class ExampleIndicator {
    public static int[] reverse(int[] nums) {
        int[] reversedArray = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        while (left < nums.length) {
            reversedArray[left] = nums[right];
            left++;
            right--;
        }

        return reversedArray;
    }
}
