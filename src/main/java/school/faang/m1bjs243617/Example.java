package school.faang.m1bjs243617;

public class Example {

    public static void reverse(int[] array) {
        if ( array.length != 0 ) {
            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }
        }
    }
}
