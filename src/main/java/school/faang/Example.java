package school.faang;

public class Example {

    public static int[] reverse(int[] arr) {
        int t = arr.length;
        for (int i = 0; i < arr.length / 2; i++) {
            int s = arr[i];
            arr[i] = arr[t - 1 - i];
            arr[t - 1 - i] = s;
        }
        return arr;
    }
}
