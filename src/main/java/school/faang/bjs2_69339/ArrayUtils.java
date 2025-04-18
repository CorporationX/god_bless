package school.faang.bjs2_69339;

public class ArrayUtils {
    public static void reverse(int[] array) {
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            r--;
            l++;
        }
    }
}