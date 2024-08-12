package faang.school.godbless.reverse;

public class Example {

    public static void reverse(int[] incomingArray) {

        for (int i = 0; i < incomingArray.length / 2; i++) {
            int temp = incomingArray[i];
            incomingArray[i] = incomingArray[incomingArray.length - 1 - i];
            incomingArray[incomingArray.length - 1 - i] = temp;
        }
    }
}
