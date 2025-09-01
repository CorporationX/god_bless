package school.faang.array_reverse;

public class Example {

    public int[] reverse(int[] array) {
        int length = array.length;
        int[] reversed = new int[length];

        for (int i = 0, j = length - 1; i < length; i++, j--) {
            reversed[i] = array[j];
        }

        return reversed;
    }
}
