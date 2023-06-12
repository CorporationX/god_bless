package faang.school.godbless;

import java.util.Arrays;
import java.util.Collections;

public class Example {
    public int[] reverse(int[] numbers){
        for (int i = 0; i < numbers.length/2; i++) {
            int q = numbers[numbers.length-1];
            numbers[numbers.length-1] = numbers[i];
            numbers[i] = q;
        }
        return numbers;
    }
}
