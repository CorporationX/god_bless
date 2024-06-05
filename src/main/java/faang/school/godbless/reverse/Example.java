package faang.school.godbless.reverse;

import lombok.ToString;

@ToString
public class Example {
    public static int[] reverse(int[] array) {
        int buffer;
        for (int i = 0; i < array.length / 2; i++) {
            buffer = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = buffer;
        }
        return array;
    }
}
