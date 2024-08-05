package faang.school.godbless;

public class Example {
    public static int[] reverse(int[] arrayInt) {
        int[] EmptyArrayInt = new int[arrayInt.length];
        int j = arrayInt.length - 1;
        for (int i = 0; i < EmptyArrayInt.length; i++) {
            EmptyArrayInt[j] = arrayInt[i];
            j--;
        }
        return EmptyArrayInt;
    }
}
