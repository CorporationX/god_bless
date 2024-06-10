package faang.school.godbless.turnAround;

public class Example {

    public static int[] reverse(int nums[]) {

        if (nums != null) {
            int k = 0;
            int i = nums.length - 1;
            while (k < i) {
                int number = nums[k];
                nums[k] = nums[i];
                nums[i] = number;
                i--;
                k++;
            }
        }
        return nums;
    }
}