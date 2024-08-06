package faang.school.godbless.BJS2_18876;

public class Example {
    public static int[] reverse(int[] array) {
        int[] reverseArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reverseArray[array.length - 1 - i] = array[i];
        }
        return reverseArray;
    }
}

