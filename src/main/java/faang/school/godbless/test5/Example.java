package faang.school.godbless.test5;

public class Example {
    public static void reverse(int[] arr) {
        int len = arr.length - 1;
        for (int i = 0; i < len / 2 + 1; i++) {
            swap(i, len - i, arr);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
