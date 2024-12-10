package school.faang.reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {53, 2, 6, 9, 12};
        System.out.println("Array before reverse-" + Arrays.toString(arr));
        Example.reverse(arr);
        System.out.println("Array after reverse-" + Arrays.toString(arr));

        //null array
        int[] arr1 = null;
        System.out.println("Array before reverse-" + Arrays.toString(arr1));
        Example.reverse(arr1);
        System.out.println("Array after reverse-" + Arrays.toString(arr1));

        //{} array
        int[] arr2 = {};
        System.out.println("Array before reverse-" + Arrays.toString(arr2));
        Example.reverse(arr2);
        System.out.println("Array after reverse-" + Arrays.toString(arr2));
    }
}
