package school.faang.revers;

public class Example {
    public static int[] reverse(int[] array) {
        int iterations = array.length / 2;
        for (int i = 0; i < iterations; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    public static int[] reversVarTwo(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (end > start) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }
}