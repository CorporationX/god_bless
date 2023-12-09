package faang.school.godbless.javaCore.revert;

public class Example {
    public static void reverse(int[] value) {
        int length = value.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = value[i];

            value[i] = value[length - 1 - i];
            value[length - 1 - i] = temp;
        }
    }
}
