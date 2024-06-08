package faang.school.godbless;

public class Application {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 18, -158, -5, 78, 65, 12, 4};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        Example revExample = new Example();
        revExample.reverse(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}