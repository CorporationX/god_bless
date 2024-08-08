package faang.school.godbless;

public class Example {
    public static int[] reverse(int[] arrayInt) {
        int[] emptyArrayInt = new int[arrayInt.length];
        int j = arrayInt.length - 1;
        for (int i = 0; i < emptyArrayInt.length; i++) {
            emptyArrayInt[j] = arrayInt[i];
            j--;
        }
        return emptyArrayInt;
    }
}
