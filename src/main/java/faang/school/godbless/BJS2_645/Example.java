package faang.school.godbless.BJS2_645;

import java.util.Arrays;

public class Example {

    public static void reverse(int[] array) {
        int[] reverseArray = new int[array.length];
        int indexReverseArray = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            reverseArray[indexReverseArray] = array[i];
            indexReverseArray++;
        }
        System.out.println(Arrays.toString(reverseArray));

    }

    public static void main(String[] args) {
        int[] array = {5, 6, 7};
        Example.reverse(array);
    }
}
