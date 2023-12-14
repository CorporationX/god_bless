package faang.school.godbless.javaCore.reverse;

public class Example {

    protected static int[] reverseArray(int[] arr) {
        int[] reverseArr = new int[arr.length];

        for (int i = 0; i < reverseArr.length; i++) {
                reverseArr[i] = arr[arr.length - i - 1];
        }
        return reverseArr;
    }
}
