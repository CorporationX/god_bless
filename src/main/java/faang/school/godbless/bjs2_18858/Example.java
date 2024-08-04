package faang.school.godbless.bjs2_18858;

public class Example {

    public static void reverse1(int[] arr) {
        var last = arr.length - 1;
        var middle = arr.length / 2;
        for (int i = 0; i < middle; i++) {
            swap(arr, i, last - i);
        }
    }

    public static void reverse2(int[] arr) {
        var left = 0;
        var right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
