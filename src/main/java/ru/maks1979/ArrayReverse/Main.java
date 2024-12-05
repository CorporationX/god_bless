package ru.maks1979.ArrayReverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 9, 11};
        Example.reverse(testArray);
        System.out.println(Arrays.toString(testArray));
    }}
