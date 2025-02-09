package school.faang;

public class Example {
    public static int[] reverse(int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.print("Error! The input array is null or empty! ");
            return nums;
        }

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            int temp = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
        return nums;
    }
}
