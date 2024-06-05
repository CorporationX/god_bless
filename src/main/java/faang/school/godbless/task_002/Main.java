package faang.school.godbless.task_002;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            int[] nums = createArray(5);
            System.out.println("Массив: " + Arrays.toString(nums));

            Example.revers(nums);
            System.out.println("Развёрнутый массив: " + Arrays.toString(nums));

            System.out.println();
        }
    }

    private static int[] createArray(int maxValue) {
        int length = new Random().nextInt(maxValue);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        return array;
    }

}
