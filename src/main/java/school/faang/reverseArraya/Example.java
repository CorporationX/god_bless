package school.faang.reverseArraya;

public class Example {
    public int[] reverseArray(int[] arrayToReverse) {
        int[] retArray = new int[arrayToReverse.length];
        for (int i = arrayToReverse.length - 1; i >= 0; i--) {
            retArray[(arrayToReverse.length - 1) - i] = arrayToReverse[i];
        }
        return retArray;
    }
}
