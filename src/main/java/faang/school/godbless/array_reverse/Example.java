package faang.school.godbless.array_reverse;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
          int[] numbers = {23, 25, 2, 894, 39, 10, 390};
        System.out.println(Arrays.toString(reverse(numbers)));
    }

    public static int[] reverse(int nums[]) {
        int i = 0;
        int j = nums.length - 1;
        while (i != j) {
            int temp;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }
}
        

