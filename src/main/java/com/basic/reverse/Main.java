package com.basic.reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4, 5};

        Example example = new Example();
        System.out.println(Arrays.toString(example.reverse(number)));

    }
}
