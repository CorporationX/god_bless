package school.faang.task_43599;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        System.out.print("nums=[");
        printArray(nums);
        System.out.println("]");

        Example.reverse(nums);
        System.out.print("reversed nums=[");
        printArray(nums);
        System.out.println("]");

    }

    private static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
