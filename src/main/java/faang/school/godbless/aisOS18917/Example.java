package faang.school.godbless.aisOS18917;

public class Example {
    public void reverse(int[] nums) {
        int start = 0;
        int last = nums.length - 1;

        while (start < last) {
            int temp = nums[start];
            nums[start] = nums[last];
            nums[last] = temp;

            start++;
            last--;
        }
    }

    public static void main(String[] args) {
        Example example = new Example();

        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Original array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        example.reverse(nums);

        System.out.println("Reversed array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
