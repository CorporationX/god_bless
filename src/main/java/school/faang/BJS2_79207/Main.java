package school.faang.BJS2_79207;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] massive = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Массив изначальный - " + Arrays.toString(massive));
        Example.reverse(massive);
        System.out.println("Массив после использования метода reverce - " + Arrays.toString(massive));
    }
}
