package BJS_7632;

public class Example {

    public static int[] reverse(int[] arr) {
        if (arr.length == 0) return arr;

        int sizeArray = arr.length - 1;
        for (int i = 0; i < (int) Math.sqrt(arr.length) + 1; i++) {
            int temp = arr[i];
            arr[i] = arr[sizeArray - i];
            arr[sizeArray - i] = temp;
        }
        return arr;
    }
}