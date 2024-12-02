package school.faang.spr1_task1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseClass {


     public static void reverse(int[] args) {

        int temp;

        for(int i = 0; i < args.length / 2; i++) {
            temp = args[i];
            args[i] = args[args.length - 1 - i];
            args[args.length - 1 - i] = temp;

        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        reverse(nums);
        System.out.println("Reversed arr: " + Arrays.toString(nums));
    }
}
