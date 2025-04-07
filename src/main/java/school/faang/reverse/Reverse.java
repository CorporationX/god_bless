package school.faang.reverse;

public class Reverse {

    @SuppressWarnings("checkstyle:WhitespaceAround")
    public static void reverse(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;

        }

    }
}
