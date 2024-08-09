package faang.school.javacore.revers;

public class Example {
    private static void reverseArray(int[] nums) {
        for (int start = 0, end = nums.length - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};

        reverseArray(array);

        for (int num : array) {
            System.out.println(num);
        }
    }
}
