package faang.school.godbless.turnaround;

public class Example {
    public void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = arr.length / 2;


        for (int i = 0; i < mid; i++) {
            swap(left + i, right - i, arr);
        }
    }

    private void swap(int leftIndex, int rightIndex, int[] arr) {
        int temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = temp;
    }
}
