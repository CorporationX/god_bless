package faang.school.godbless.intro.expand;

public class Example {
    public static int[] reverse(int[] array) {
        for (int start = 0, end = array.length - 1; end > start; start++, end--) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        return array;
    }
}
