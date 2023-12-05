package faang.school.godbless.reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] reverse = Example.reverseArray(testArr);

        System.out.println(Arrays.toString(reverse));
    }
}
