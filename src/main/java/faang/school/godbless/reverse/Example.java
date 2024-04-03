package faang.school.godbless.reverse;

public class Example {
    static void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int temp;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}