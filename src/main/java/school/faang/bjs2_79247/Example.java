package school.faang.bjs2_79247;

public class Example {
    public void reverse(int[] array) {
        quickReverse(array, 0, array.length - 1);
    }

    public static void quickReverse(int[] array, int low, int high) {
        int mid;
        if (low < high) {
            mid = divide(array, low, high);
            quickReverse(array, low, mid - 1);
            quickReverse(array, mid + 1, high);
        }
    }

    public static int divide(int[] array, int low, int high) {
        int mid = array[high];
        int temp;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] >= mid) {
                i++;
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
