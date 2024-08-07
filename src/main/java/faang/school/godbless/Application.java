package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        Example example = new Example();
        int[] nums = {1, 2, 3, 4, 5};

        example.reverse(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}