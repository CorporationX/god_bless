package school.faang.task_43605;

public class Example {
    public static int[] reverse(int[] nums) {

        if (nums.length == 0) {
            System.out.println("array is empty");
            return new int[]{};
        }
        if (nums == null) {
            System.out.println("array is null");
            return new int[]{};
        }

        int temp;
        for (int i = 0; i < nums.length / 2; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return nums;
    }
}
