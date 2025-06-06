package school.faang.reverse;

public class Example {

    public static int[] reverse(int[] array) {
        for (int i = 0; array.length / 2 > i; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}