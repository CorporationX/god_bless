package school.faang;

public class Example {

    public static void reverse(int[] nums) {
        if (nums == null || nums.length <= 1) {
            System.out.println("NULL/empty array or containing single element");
        } else {
            for (int i = 0; i < nums.length / 2; i++) {
                int saved = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = saved;
            }
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println("<---reversed array");
        }
    }


    public static void main(String[] args) {
        int[] original = {10, 20, 30, 40, 50, 55, 60, 65, 70};
        for (int num : original) {
            System.out.print(num + " ");
        }
        System.out.println("<---original array");
        reverse(original);
    }
}