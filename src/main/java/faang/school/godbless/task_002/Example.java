package faang.school.godbless.task_002;

public class Example {

    /**
     * Разворачиввает массив.
     *
     * @param nums - целочисленный массив.
     */
    public static void revers(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        for (int i = 0, j = nums.length - 1; i < nums.length / 2; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
