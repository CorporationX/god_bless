package faang.school.godbless.reverse;

public class Example {
    public static void reverse (int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // Обмен значениями
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            // Переход к следующим элементам
            left++;
            right--;
        }
    }
}
