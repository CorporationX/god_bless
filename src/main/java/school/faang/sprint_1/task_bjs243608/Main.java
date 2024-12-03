package school.faang.sprint_1.task_bjs243608;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testArray1 = {1, 2, 3, 4, 5};
        int[] testArray2 = {1, -2, 3, 4, 5, -6};
        int[] testArray3 = {};
        int[] testArray4 = null;

        Example.reverse(testArray1);
        Example.reverse(testArray2);
        Example.reverse(testArray3);
        Example.reverse(testArray4);

        System.out.println(Arrays.toString(testArray1));
        System.out.println(Arrays.toString(testArray2));
        System.out.println(Arrays.toString(testArray3));
        System.out.println(Arrays.toString(testArray4));
    }
}
