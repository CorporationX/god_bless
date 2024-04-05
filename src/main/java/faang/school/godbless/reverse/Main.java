package faang.school.godbless.reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Example ex = new Example();
        int[] source = new int[]{1,2,3,4,5,6};
        System.out.println("Source array: " + Arrays.toString(source));
        int[] reversed = ex.reverse(source);
        System.out.println("Reversed array: " + Arrays.toString(reversed));
    }
}
