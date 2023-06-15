package Revert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Revert.Example.reverse;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        reverse(nums);

        System.out.println(Arrays.toString(nums));

        /*
            можно конечно намного проще сделать)

            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            Collections.reverse(numbers);

            но, думаю, в рамках данной задачи это читерство

         */
    }
}
