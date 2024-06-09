package faang.school.godbless.reverse;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] arrayReverse = Example.reverse(array);
        System.out.println(Arrays.toString(arrayReverse));
    }
}
