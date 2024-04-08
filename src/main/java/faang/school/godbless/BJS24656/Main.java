package faang.school.godbless.BJS24656;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {1, 2};
        int[] arr3 = {1};
        int[] arr4 = {};

        System.out.println("Измененный массив: " + Arrays.toString(Example.reverse(arr)));
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Измененный массив: " + Arrays.toString(Example.reverse(arr1)));
        System.out.println("Исходный массив: " + Arrays.toString(arr1));
        System.out.println("Измененный массив: " + Arrays.toString(Example.reverse(arr2)));
        System.out.println("Исходный массив: " + Arrays.toString(arr2));
        System.out.println("Измененный массив: " + Arrays.toString(Example.reverse(arr3)));
        System.out.println("Исходный массив: " + Arrays.toString(arr3));
        System.out.println("Измененный массив: " + Arrays.toString(Example.reverse(arr4)));
        System.out.println("Исходный массив: " + Arrays.toString(arr4));
    }
}
