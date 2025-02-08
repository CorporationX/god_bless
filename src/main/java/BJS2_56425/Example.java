package BJS2_56425;

public class Example {
    public static int[] reverse(int[] arr) {
        if (arr == null) {
            return null;
        }

        if (arr.length <= 1) {
            return arr;
        }

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }
}
