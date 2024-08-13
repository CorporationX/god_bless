package faang.school.godbless.BJS2_18929;

public class Example {
    /**
     * Метод разворачивает переданный массив целых чисел.
     *
     * @param nums массив целых чисел
     */
    public void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
