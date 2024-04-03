package Turned;

public class Example {
    public static void reverse(int[] arr) {
        int leftIter = 0;
        int rightIter = arr.length - 1;
        while (leftIter < rightIter) {
            int variable = arr[leftIter];
            arr[leftIter] = arr[rightIter];
            arr[rightIter] = variable;
            leftIter++;
            rightIter--;
        }
    }
}
