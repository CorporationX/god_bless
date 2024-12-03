package school.faang.task43636reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Начальный массив   " + Arrays.toString(nums));
        Example.reverse(nums);
        System.out.println("Развернутый массив " + Arrays.toString(nums));

    }

}
