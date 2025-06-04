package school.faang.reverse;

public class Example {

    public static int[] reverse(int[] array) {
        int k = 0;
        int[] result = new int[array.length];
        for (int i = array.length; i > 0; i--) {
            result[k] = array[i - 1];
            k++;
        }
        return result;
    }
}
