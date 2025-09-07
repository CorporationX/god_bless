package school.faang.Bjs2_85563;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testArray1 = new int[]{1, 2, 3, 4, 5};
        int[] testArray2 = new int[]{7, 5, 9, 4, 1, 8};
        int[] testArray3 = new int[0];
        int[] testArray4 = new int[]{7};
        Example.reverse(testArray1);
        Example.reverse(testArray2);
        Example.reverse(testArray3);
        Example.reverse(testArray4);
        System.out.println(Arrays.toString(testArray1));
        System.out.println(Arrays.toString(testArray2));
        System.out.println(Arrays.toString(testArray3));
        System.out.println(Arrays.toString(testArray4));
    }
}
