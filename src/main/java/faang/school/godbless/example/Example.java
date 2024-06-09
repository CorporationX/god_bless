package faang.school.godbless.example;

public class Example {

    public static int[] arrayReverse(int[] array) {
        var length = array.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = temp;
        }
        return array;
    }
}
