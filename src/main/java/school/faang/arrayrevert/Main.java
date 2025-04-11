package school.faang.arrayrevert;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.printf("Массив пришел такой: %s%n", Arrays.toString(arr));
        Example.reverse(arr);
        System.out.printf("Массив вышел такой: %s%n", Arrays.toString(arr));
    }
}