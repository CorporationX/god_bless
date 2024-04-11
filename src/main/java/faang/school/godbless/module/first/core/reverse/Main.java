package faang.school.godbless.module.first.core.reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrayOfInts = { 1, 2, 3, 4, 5, 2, 3, 41, 5 };
        Example.reverse(arrayOfInts);
        System.out.println(Arrays.toString(arrayOfInts));
    }
}
