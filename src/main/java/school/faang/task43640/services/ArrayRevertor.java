package school.faang.task43640.services;

public class ArrayRevertor {
    public static int[] reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            j = nums.length - i - 1;
            if (j > i) {
                int num = nums[i];
                nums[i] = nums[j];
                nums[j] = num;
                j--;
            }
            i++;
        }

        return nums;
    }
}
