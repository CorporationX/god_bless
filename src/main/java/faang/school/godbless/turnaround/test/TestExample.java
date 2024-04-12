package faang.school.godbless.turnaround.test;

import faang.school.godbless.turnaround.Example;

import java.util.Arrays;

public class TestExample {
    public static void main(String[] args) {
        int[] oddLengthArrActual = new int[]{1, 2, 3, 4, 5};
        int[] evenLengthArrActual = new int[]{1, 2, 3, 4, 5, 6};
        int[] oddLengthArrExpected = new int[]{5, 4, 3, 2, 1};
        int[] evenLengthArrExpected = new int[]{6, 5, 4, 3, 2, 1};

        Example myExample = new Example();
        myExample.reverse(oddLengthArrActual);
        myExample.reverse(evenLengthArrActual);

        System.out.println(Arrays.toString(oddLengthArrActual));
        System.out.println(Arrays.toString(evenLengthArrActual));

        assert Arrays.equals(oddLengthArrExpected, oddLengthArrActual);
        assert Arrays.equals(evenLengthArrExpected, evenLengthArrActual);
    }
}
