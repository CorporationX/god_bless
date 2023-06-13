package faang.school.godbless.reverse;

import java.util.Arrays;
import java.util.Collections;

public class Example {
    public static void reverse(int[] numbers){
        Integer[] array = new Integer[numbers.length];
        for (int i = 0; i < 5; i++) {
            array[i] = numbers[i];
        }
        Collections.reverse(Arrays.asList(array));
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = array[i];
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        reverse(numbers);

        System.out.println("reverse array ---> " + Arrays.toString(numbers));
    }
}
