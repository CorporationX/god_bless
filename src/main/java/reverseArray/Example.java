package reverseArray;

public class Example {
    public static int[] reverse(int[] array) {

        int len = array.length;

        for (int i = 0; i < len / 2; i++) {
            int val = array[i];
            array[i] = array[len - 1 - i];
            array[len - 1 - i] = val;
        }
        return array;
    }
}