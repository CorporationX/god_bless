package school.faang;

public class Example {
    public static void revers(int[] nums) {
        int temp;
        if (nums == null) {
            System.out.println(" nums is null .");
        } else if (nums.length == 0) {
            System.out.println("nums is empty .");
        } else {
            for (int i = 0; i < nums.length / 2; i++) {
                temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
        }
    }
}
