package reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr1));
        Example.reverse(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(arr2));
        Example.reverse(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
