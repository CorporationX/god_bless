package school.faang.BJS2_43599;

public class Example {

    public static void reverse(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp =  nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    private static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        System.out.print("nums=[");
        printArray(nums);
        System.out.println("]");

        reverse(nums);
        System.out.print("reversed nums=[");
        printArray(nums);
        System.out.println("]");

    }
}

