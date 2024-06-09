package faang.school.godbless.BJS2_7671;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array4 = new int[]{1, 2, 3, 4};
        int[] array5 = new int[]{1, 2, 3, 4, 5};
        Example.reverse(array4);
        Example.reverse(array5);
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
    }

}
