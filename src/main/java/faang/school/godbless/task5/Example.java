package faang.school.godbless.task5;

public class Example {

    public static int[] reverse(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < array.length / 2; i++) {
            int v = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = v;
        }
        return array;
    }
}
