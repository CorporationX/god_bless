package faang.school.godbless;

public class Example {
    public static int[] reverse(int[] toReverse) {
        int[] reversed = new int[toReverse.length];
        int j = 0;
        for (int i = reversed.length - 1; i >= 0; i--) {
            reversed[j] = toReverse[i];
            j++;
        }
        return reversed;
    }
}

