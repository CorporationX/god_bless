package school.faang;

public class Example {
    public static void reverse(int[] num) {
        if (num == null || num.length < 2) {
            return;
        }

        int totalNum = num.length;

        for (int i = 0; i < totalNum / 2; i++) {
            int oppositeIndex = totalNum - 1 - i;

            int temp = num[i];
            num[i] = num[oppositeIndex];
            num[oppositeIndex] = temp;
        }
    }
}

