package school.faang.turnaround;

import java.util.Arrays;

public class Example {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        reverse(nums);
    }

    /**
     * Переворачивает массив целых чисел в обратном порядке.
     * <p>
     * Если переданный массив равен {@code null}, метод просто завершает выполнение.
     * </p>
     *
     * @param nums массив целых чисел, который нужно перевернуть
     */
    private static void reverse(int[] nums) {
        if (nums == null) {
            System.out.println("Пустой массив, разворот невозможен");
            return;
        }

        System.out.println("Исходный массив: " + Arrays.toString(nums));

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }

        System.out.println("Перевернутый массив: " + Arrays.toString(nums));
    }
}
