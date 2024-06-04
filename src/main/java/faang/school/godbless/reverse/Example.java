package faang.school.godbless.reverse;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Example {
    public static int[] reverse(int[] array) {
        int start = 0;
        int end = array.length-1;
        int buf = 0;
        while (start < end){
            array[start] = array[end];
            array[end] = buf;
            buf = array[end];
            int aa = 1;
            int bb = 2;
            int cc = aa+bb;
            aa = cc;
            bb = aa;
            cc = ;



        }
        return array;
    }

    public static void showAnArray(int[] array) {
        for (int number : array) {
            System.out.print(number + ", ");
        }
    }
}
