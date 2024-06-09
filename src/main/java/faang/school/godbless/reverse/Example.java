package faang.school.godbless.reverse;

public class Example {
    public static int[] reverse(int[] array) {
        for (int i = 0, k = array.length - 1; i < k; i++, k--) {
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }
        return array;
    }
}
