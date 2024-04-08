package faang.school.godbless.reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Example arrayReverser = new Example();
        int[] source = {4,1,3,8,2,7};
        System.out.println("Source array: " + Arrays.toString(source));
        int[] reversed = arrayReverser.reverse(source);
        System.out.println("Reversed array: " + Arrays.toString(reversed));
    }
}
