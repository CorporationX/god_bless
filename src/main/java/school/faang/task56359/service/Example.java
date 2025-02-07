package school.faang.task56359.service;

public class Example {
    /**
     * Переворачивает порядок элементов в массиве.
     *
     * @param nums массив целых чисел для переворачивания
     *             используем два указателя, которые смещаются от края к центру при каждой итерации.
     * @return измененный массив {@code nums} с элементами в обратном порядке
     */
    public static int[] reverse(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым.");
        }
        int left = 0;
        int right = nums.length;
        int center = right / 2;
        for (int i = 0; i < center; i++) {
            int buffer = nums[left];
            nums[i] = nums[right - 1];
            nums[right - 1] = buffer;
            right--;
            left++;
        }
        return nums;
    }
}