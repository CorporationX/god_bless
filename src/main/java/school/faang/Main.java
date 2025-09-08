package school.faang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину массива: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println("Исходный массив: " + Arrays.toString(nums));

        Example example = new Example();
        example.reverse(nums);
        System.out.println("Перевернутый массив: " + Arrays.toString(nums));
    }
}