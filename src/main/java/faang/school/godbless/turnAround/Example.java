package faang.school.godbless.turnAround;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] arr){
        for (int i = 0; i < arr.length/2; i++) {
            int buf;
            buf = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = buf;
        }
    }
}
