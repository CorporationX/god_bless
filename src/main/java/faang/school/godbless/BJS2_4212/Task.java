package faang.school.godbless.BJS2_4212;

public class Task {
    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int num = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = num;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        reverse(nums);
        for (int arr : nums) {
            System.out.print(arr + "  ");
        }
    }
}
