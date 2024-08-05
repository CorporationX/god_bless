package Reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {7,6,5,4,3,2,1,0};
        Example.reverse(array);
        System.out.println(Arrays.toString(array));
    }
}
