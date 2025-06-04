package school.faang.module1.bjs2_79193;

public class Example {

    public static void reverse(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
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
    }
}
