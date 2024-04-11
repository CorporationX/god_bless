package faang.school.godbless.module.first.core.reverse;

public class Example {
    public static void reverse(int[] arrayOfInts) {
        for (int i = 0; i < arrayOfInts.length / 2; i++) {
            int temp = arrayOfInts[i];
            arrayOfInts[i] = arrayOfInts[arrayOfInts.length - 1 - i];
            arrayOfInts[arrayOfInts.length - 1 - i] = temp;
        }
    }
}
