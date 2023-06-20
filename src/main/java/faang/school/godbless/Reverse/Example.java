package faang.school.godbless.Reverse;

public class Example {
    public static int[] reverse(int[] array) {
        int n = array.length;
        int i = 0;
        int j = n - 1;
        while (i < n / 2) {
            swap(array, i++, j--);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
