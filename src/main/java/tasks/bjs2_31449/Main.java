package tasks.bjs2_31449;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Массив чисел");
        int[] nums = {5, 9, 0, 1, 4, 2, 3, 2};
        System.out.println("Массив чисел : " + Arrays.toString(nums));
        Example.reverse(nums);
        System.out.println("Перевернутый массив чисел : " + Arrays.toString(nums));
    }
}
