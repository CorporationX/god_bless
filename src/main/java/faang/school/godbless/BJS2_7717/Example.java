package faang.school.godbless.BJS2_7717;
import java.util.Arrays;

public class Example {

    public static int[] reverseArray(int[] array) {

        for (int start = 0, end = array.length - 1; start < end; start++, end--) {

            int startValue = array[start];
            array[start] = array[end];
            array[end] = startValue;

        }

        return array;
    }

    public static void main(String[] args) {
        int[] first = new int[]{1, 2, 3, 4, 5};

        System.out.println((Arrays.toString(reverseArray(first))));
    }
}
