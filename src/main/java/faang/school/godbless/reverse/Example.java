package faang.school.godbless.reverse;

public class Example {
    public static void reverse(int[] array) {
        int j = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            j--;
        }
    }
}
