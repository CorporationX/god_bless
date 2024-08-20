package faang.school.godbless.reverse;

public class Example {

    public static int[] reverse(int[] arr) {
        int temp;
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}
