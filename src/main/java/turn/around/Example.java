package turn.around;

public class Example {
    public static void reverse(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start<end) {
            int arrStart = array[start];
            array[start] = array[end];
            array[end] = arrStart;
            start++;
            end--;
        }
    }
}
