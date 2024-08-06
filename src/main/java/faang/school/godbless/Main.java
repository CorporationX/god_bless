package faang.school.godbless;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        int[] arrayInt1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arrayInt1));
        arrayInt1 = example.reverse(arrayInt1);
        System.out.println(Arrays.toString(arrayInt1));
        System.out.println();

        int[] arrayInt2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arrayInt2));
        arrayInt2 = example.reverse(arrayInt2);
        System.out.println(Arrays.toString(arrayInt2));
        System.out.println();

        int[] arrayInt3 = {8};
        System.out.println(Arrays.toString(arrayInt3));
        arrayInt3 = example.reverse(arrayInt3);
        System.out.println(Arrays.toString(arrayInt3));
        System.out.println();

        int[] arrayInt4 = {8, 1};
        System.out.println(Arrays.toString(arrayInt4));
        arrayInt4 = example.reverse(arrayInt4);
        System.out.println(Arrays.toString(arrayInt4));
    }
}
