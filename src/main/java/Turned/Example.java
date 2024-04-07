package Turned;

public class Example {
    private static void swap(int[] arr, int num1, int num2) {
        int variable = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = variable;
    }
    public static void reverse(int[] arr) {
        int leftPointer = 0;
        int rightPointer = arr.length - 1;
        while (leftPointer < rightPointer) {
            swap(arr, leftPointer, rightPointer);
            leftPointer++;
            rightPointer--;
        }
    }
}
