package ru.kraiush.lambda.BJS2_21037;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Common {

    public static final String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";

    public static final char[] convertStringArrayToChar(String[] words) {
        return Arrays.stream(words)
                .collect(Collectors.joining())
                .toCharArray();
    }

    public static final char[] reverseUseTempArr(char array[]) {

        char[] reversedArray = new char[array.length];
        int j = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            reversedArray[j] = array[i];
            j = j - 1;
        }
        return reversedArray;
    }
}
