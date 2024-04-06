package faang.school.godbless.reverse;

import java.util.Arrays;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("After reverse: " + Arrays.toString(reverse(nums)));
    }

    public static int[] reverse(int[] arr) {
        int n = arr.length;
        for (int i = 1; i <= n / 2; i++) {
            int k = arr[i - 1];
            arr[i - 1] = arr[n - i];
            arr[n - i] = k;
        }
        return arr;


    }
}
