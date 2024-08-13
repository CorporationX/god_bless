package faang.school.godbless.dolbahlop;

public class Example {
    public static void reverse(int[] array){
        if (array == null || array.length <= 1) {
            return;
        }

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
