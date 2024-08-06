package turn_around;

public class Example {

    public static void reverse(int[] nums) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        while (leftPointer <= rightPointer) {
            swap(nums, leftPointer, rightPointer);
            leftPointer++;
            rightPointer--;
        }
    }

    private static void swap(int[] nums, int sourceIndex, int targetIndex) {
        int temp = nums[sourceIndex];
        nums[sourceIndex] = nums[targetIndex];
        nums[targetIndex] = temp;
    }
}
