package faang.school.godbless.reverse;

public class Example {

    public static int[] reverse(int... nums) {
        int[] reversed = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            reversed[left] = nums[right];
            reversed[right] = nums[left];
            left++;
            right--;
        }

        return reversed;
    }

}
