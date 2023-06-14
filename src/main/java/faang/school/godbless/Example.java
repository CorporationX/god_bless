package faang.school.godbless;

public class Example {

    public static int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int bufferStart = array[i];
            int bufferEnd = array[array.length - 1 - i];
            array[i] = bufferEnd;
            array[array.length - 1 - i] = bufferStart;
        }
        return array;
    }
}
