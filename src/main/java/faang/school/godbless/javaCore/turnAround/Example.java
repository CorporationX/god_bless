package faang.school.godbless.javaCore.turnAround;

public class Example {
    public static int[] reverse(int[] array) {
        if (array != null) {
            int temp;
            for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
}