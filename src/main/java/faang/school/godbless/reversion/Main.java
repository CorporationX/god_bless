package faang.school.godbless.reversion;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 7, 5};

        Example.reverse(array);
        System.out.println(Arrays.toString(array));
    }
}
