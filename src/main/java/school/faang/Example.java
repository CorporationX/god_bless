package school.faang;

public class Example {


    public static void reverse(int[] nums) {

        if (nums.length == 0) {
            System.out.println("Empty array");
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int temp;

        while (left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}





