package faang.school.godbless.bjs218867;

public class Example {

    public int[] reverse(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int number = nums[end];
            nums[end] = nums[start];
            nums[start] = number;
            start++;
            end--;
        }
        return nums;
    }
}
