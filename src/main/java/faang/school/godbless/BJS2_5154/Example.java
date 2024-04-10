package faang.school.godbless.BJS2_5154;

public class Example {
    public static int[] reverse(int[] arrayToReverse) {
        int[] reversedArray = new int[arrayToReverse.length];
        for (int i = 0; i < arrayToReverse.length; i++) {
            reversedArray[i] = arrayToReverse[arrayToReverse.length - i - 1];
        }
        return reversedArray;
    }
}
