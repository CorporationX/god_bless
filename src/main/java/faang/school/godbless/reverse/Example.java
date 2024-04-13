package faang.school.godbless.reverse;

import java.util.Arrays;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        int size = scanner.nextInt();
        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("After reverse: " + Arrays.toString(reverse(nums)));
    }

    public static int[] reverse(int[] arr) {
        int arrLen = arr.length;
        for (int i = 1; i <= arrLen / 2; i++) {
            int temp = arr[i - 1];
            arr[i - 1] = arr[arrLen - i];
            arr[arrLen - i] = temp;
        }
        return arr;
    }
}
