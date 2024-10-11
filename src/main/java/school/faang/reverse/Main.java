package school.faang.reverse;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        Example.reverse(nums);

        // Print the reversed array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
