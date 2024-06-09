package faang.school.godbless.reverse;

public class Example {

    public static int[] reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int mid = left + (right - left) / 2;


        for (int i = 0; i <= mid; i++) {

            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }


        return array;
    }
}
