package faang.school.godbless;

public class Example {
    public static int[] reverse(int[] array) {
        int n = array.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = array[n - i - 1];
        }
        return reversed;
    }
}
