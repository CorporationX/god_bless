package faang.school.godbless.reverse;

public class Example {

    public static int[] reverse (int[] nums){
        if (nums == null) {
            throw new IllegalArgumentException("An array can't be empty");
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        return nums;
    }
}