package faang.school.godbless;

public class Example {
    public static int[] reverse(int[] numbers) {
        int numLen = numbers.length;
        int[] reversNum = new int[numLen];
        for (int i = numLen - 1, j = 0; i > 0; i--, j++) {
            reversNum[i] = numbers[j];
        }
        return reversNum;
    }
}
