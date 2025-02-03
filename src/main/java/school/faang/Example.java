package school.faang;


import java.util.Random;

public class Example {

    /**
     * The reverse method expands the passed array of integers.
     *
     * @param nums array of integers to expand.
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
        int size = 10;

        int[] array = new int[size];

        // Creating a Random object to generate random numbers
        Random random = new Random();

        // Filling the array with random numbers
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("The original array:");
        printArray(array);

        reverse(array);

        System.out.println("The reversed array:");
        printArray(array);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}