package faang.school.godbless.reverse;

public class Example {

    protected static int[] reverseArray(int[] arr) {
        int[] reverseArr = new int[arr.length];

        for (int i = arr.length - 1; i > 0; ) {
            for (int j = 0; j < arr.length; j++) {
                reverseArr[j] = arr[i--];
            }
        }
        return reverseArr;
    }
}
