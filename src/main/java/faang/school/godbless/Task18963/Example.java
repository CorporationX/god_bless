package faang.school.godbless.Task18963;

import java.util.Arrays;

public class Example {

    public void reverse (int[] array){
        int length = array.length - 1;

        int[] massiv = new int[array.length];
        int result = massiv.length;

        for (int i = length; i >= 0; i--) {
            for (int j = 0; j < result; j++) {
                massiv[j] = array[i];
                i -= 1;
            }
        }
        System.out.println(Arrays.toString(massiv));
    }
}
