package reverseArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = {1,2,3,4,5};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(Example.reverse(array)));
    }
}