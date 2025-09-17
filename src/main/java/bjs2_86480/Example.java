package bjs2_86480;

public class Example {

    // Метод для разворота массива
    public static void reverse(int[] nums) {
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

    // Тестируем
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        System.out.print("Source array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        reverse(nums);

        System.out.print("\nРазвёрнутый массив: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
