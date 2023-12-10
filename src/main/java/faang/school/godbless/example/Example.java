package faang.school.godbless.example;

public class Example {

    public static int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int min = array[i];
            int max = array[array.length - i - 1];

            array[i] = max;
            array[array.length - i - 1] = min;
        }

        return array;
    }
}
