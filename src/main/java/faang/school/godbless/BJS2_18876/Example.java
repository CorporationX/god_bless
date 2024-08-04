package faang.school.godbless.BJS2_18876;

public class Example {
    public static int[] reverse(int[] array) {
        int[] reverse_array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reverse_array[array.length - 1 - i] = array[i];
        }
        return reverse_array;
    }
}

