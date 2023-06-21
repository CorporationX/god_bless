package faang.school.godbless.test5_Sprint2;

public class Example {
    public static void reverse(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            swap(i, len - i-1, arr);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
