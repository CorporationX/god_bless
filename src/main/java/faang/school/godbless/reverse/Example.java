package faang.school.godbless.reverse;

//import java.util.Arrays;
//import java.util.Collections;

public class Example {
    static void reverse(Integer[] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
