package school.faang.bjs243602;

public class Exemple {
    public static int[] nums = {1, 2, 3, 4, 5};

    public static void reverse(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        printArray(nums, "reversed");
    }

    public static void printArray(int[] nums, String name) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println(name);
    }
}