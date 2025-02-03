package school.faang;


public class Example {

    /**
     * Метод reverse разворачивает переданный массив целых чисел.
     *
     * @param nums массив целых чисел, который нужно развернуть.
     */
    public static void reverse(int[] nums) {
        if (nums == null || nums.length <= 1) {
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

    public static void main(String[] args) {
        int[] nums = {5, 10, 20, 50, 100, 1};
        System.out.println("The original array:");
        printArray(nums);

        reverse(nums);

        System.out.println("The reversed array:");
        printArray(nums);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}