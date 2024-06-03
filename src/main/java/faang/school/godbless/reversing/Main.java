package faang.school.godbless.reversing;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] reversedArray = Example.reverse(array);
        System.out.println(Arrays.toString(reversedArray));
    }
}
