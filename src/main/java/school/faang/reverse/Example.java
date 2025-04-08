package school.faang.reverse;

public class Example {

    public static void reverse(int[] nums) {
        if (nums == null) {
            System.out.println("Массив не может быть null.");
            return;
        }
        if (nums.length <= 1) {
            return;
        }
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