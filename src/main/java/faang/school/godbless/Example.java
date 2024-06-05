package faang.school.godbless;

public class Example {

    public static int[] reverse(int[] array) {
        int[] reversed = new int[array.length];
        int first = 0;
        int last = array.length - 1;

        while (first <= last) {
            int temp = array[first];
            reversed[first] = array[last];
            reversed[last] = temp;
            first++;
            last--;
        }
        return reversed;
    }
}
