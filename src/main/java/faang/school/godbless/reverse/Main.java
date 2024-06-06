package faang.school.godbless.reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrays = {1, 35, 453, 3, 344, 66, 5};
        int[] reversedArray = Example.reverse(arrays);
        System.out.println("reversedArray = " + Arrays.toString(reversedArray));
    }
}