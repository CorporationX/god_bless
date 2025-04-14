package school.faang;

public class Example {

    public static void reverse(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        // Разворачиваем массив, меняя элементы местами
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            int i = start++;
            end--;
        }
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
