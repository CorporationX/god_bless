package faang.school.godbless.test5_Sprint2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testArrEven = {0, 1, 2, 3, 4, 5};
        System.out.printf("test1-even\n%s\n",Arrays.toString(testArrEven));
        Example.reverse(testArrEven);
        System.out.println(Arrays.toString(testArrEven));

        int[] testArrOdd = {0, 1, 2, 3, 4};
        System.out.printf("test2 - odd\n%s\n",Arrays.toString(testArrOdd));
        Example.reverse(testArrOdd);
        System.out.println(Arrays.toString(testArrOdd));
    }
}
