package faang.school.godbless.reversion;

public class Example {
    public static void reverse(int[] array) {
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            int savedNum = array[i];
            array[i] = array[j];
            array[j] = savedNum;
            i++;
            j--;
        }
    }
}
