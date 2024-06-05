package faang.school.Kandes_BJS2_7649;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(array));

        Example.reverse(array);

        System.out.println(Arrays.toString(array));

    }
}