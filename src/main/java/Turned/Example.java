package Turned;

public class Example {
    protected static void swap(int[] arr, int num1, int num2) {
        int variable = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = variable;
    }

    public static void reverse(int[] arr) {
        int leftIter = 0;
        int rightIter = arr.length - 1;
        while (leftIter < rightIter) {
            swap(arr, leftIter, rightIter);
            leftIter++;
            rightIter--;
        }
    }
}
