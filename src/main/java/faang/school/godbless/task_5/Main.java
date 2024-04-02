package faang.school.godbless.task_5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] test1 = new int[]{1,2,3,4,5};
        int[] test2 = new int[]{1};
        int[] test3 = new int[]{1,2};

        System.out.println("IN_PLACE");
        Example.reverseInPlace(test1);
        System.out.println(Arrays.toString(test1));
        Example.reverseInPlace(test2);
        System.out.println(Arrays.toString(test2));
        Example.reverseInPlace(test3);
        System.out.println(Arrays.toString(test3));

        test1 = new int[]{1,2,3,4,5};
        test2 = new int[]{1};
        test3 = new int[]{1,2};

        System.out.println("OUT_OF_PLACE");
        System.out.println(Arrays.toString(Example.reverse(test1)));
        System.out.println(Arrays.toString(Example.reverse(test2)));
        System.out.println(Arrays.toString(Example.reverse(test3)));
    }
}
