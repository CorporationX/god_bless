package school.faang.naughtwoBJS256410;

public class Example {
    public static int[] reverse(int[] nums) {
        for (Integer num : nums) {
            if (num == null) {
                throw new IllegalArgumentException("Empty value!");
            }
        }

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int num = nums[i];
            nums[i] = nums[j];
            nums[j] = num;
            i++;
            j--;
        }
        return nums;
    }
}
