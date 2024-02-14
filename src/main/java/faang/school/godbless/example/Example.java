package faang.school.godbless.example;

public class Example {

    public static int[] reverse(int[] array) {
        int arrayMaxLength = array.length - 1;

        for (int i = 0; i < array.length / 2; i++) {
            int min = array[i];
            int max = array[arrayMaxLength - i];

            array[i] = max;
            array[arrayMaxLength - i] = min;
        }

        return array;
    }
}
