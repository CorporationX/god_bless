package school.faang.bjs2_43619;

public class Example {

    public static void reverse(int[] nums) {
        if (nums == null) {
            System.out.println("Массив равен null");
            return;
        }
        if (nums.length == 0) {
            System.out.println("Массив пустой");
            return;
        }

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
