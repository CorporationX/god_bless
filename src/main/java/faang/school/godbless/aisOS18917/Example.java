package faang.school.godbless.aisOS18917;

public class Example {
    public int[] reverse(int[] nums) {
        int[] reversed = new int[nums.length];
        int start = 0;
        int last = nums.length - 1;

        while (start <= last) {
            reversed[start] = nums[last];
            reversed[last] = nums[start];
            start++;
            last--;
        }

        return reversed;
    }

    public static void main(String[] args) {
        Example example = new Example();

        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Original array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        int[] reversed = example.reverse(nums);

        System.out.println("Reversed array: ");
        for (int num : reversed) {
            System.out.print(num + " ");
        }

    }
}