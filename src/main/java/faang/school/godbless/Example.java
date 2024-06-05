package faang.school.godbless;

public class Example {
    public int[] reverse(int[] arr) {
        int[] reversedArr = new int[arr.length];
        for (int start = 0, end = arr.length - 1; start <= end; start++, end--) {
            reversedArr[start] = arr[end];
            reversedArr[end] = arr[start];
        }
        return reversedArr;
    }
}
