package BJS2_56425;

public class Example {
    /**
     * Reverses the given array.
     *
     * @param arr the array to reverse, can be null
     * @return the reversed array
     */
    public static int[] reverse(int[] arr) {
        if (arr == null) {
            return null;
        }

        if (arr.length <= 1) {
            return arr;
        }

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            int rightIndex = arr.length - 1 - i;
            arr[i] = arr[rightIndex];
            arr[rightIndex] = temp;
        }
        return arr;
    }
}
