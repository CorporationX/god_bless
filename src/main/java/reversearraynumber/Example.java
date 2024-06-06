package reversearraynumber;

public class Example {

    public int[] reverseArray(int[] array) {
        if (array.length < 1) {
            throw new IllegalArgumentException("Array must be filled!");
        }
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        return array;
    }
}
