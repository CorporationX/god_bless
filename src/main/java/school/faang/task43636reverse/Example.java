package school.faang.task43636reverse;

public class Example {

    public static void reverse(int[] nums) {
        if (nums.length == 0) {
            System.out.println("Пустой массив");
            return;
        }
        int temp;

        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;

        }

    }
}
