package core.reverse;

public class Example {

    public static int[] reverseArray(int[] array) {
        int order = 0;
        int[] newArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[order++] = array[i];
        }
        return newArray;
    }
}
