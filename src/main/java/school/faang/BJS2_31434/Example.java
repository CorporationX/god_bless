package school.faang.BJS2_31434;

public class Example {

    // Метод для разворота массива
    public void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Меняем местами элементы, начиная с краёв массива
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
