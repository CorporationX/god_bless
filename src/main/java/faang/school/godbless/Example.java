package faang.school.godbless;

import java.util.Arrays;

public class Example {
    public static int[] revers(int[] array){
        int start = 0;
        int finish = array.length - 1;
        while (start < finish){
            int temp = array[start];
            array[start++] = array[finish];
            array[finish--] = temp;
        }
        return array;
//        int[] reversInt = new int[array.length];
//        int index = 0;
//        for (int i = array.length - 1; i >=0 ; i--) {
//            reversInt[index++] = array[i];
//        }
//        return reversInt;
    }
}
