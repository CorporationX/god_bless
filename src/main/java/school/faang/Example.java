package school.faang;

public class Example {
    public void reverse(int[] array) {
        int temp;
        int size = array.length;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
    }
}
