package school.faang;

public class Example {

    public static int[] reverse(int[] arr) {
        int arraySize = arr.length;
        for (int i = 0; i < arr.length / 2; i++) {
            int s = arr[i];
            arr[i] = arr[arraySize - 1 - i];
            arr[arraySize - 1 - i] = s;
        }
        return arr;
    }
}
