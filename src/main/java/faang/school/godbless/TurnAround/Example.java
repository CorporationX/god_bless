package faang.school.godbless.TurnAround;

import java.util.ArrayList;

public class Example {
    public static void reverse(int[] numbers) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;
        while (leftPointer < rightPointer) {
            int cashNumber = numbers[leftPointer];
            numbers[leftPointer] = numbers[rightPointer];
            numbers[rightPointer] = cashNumber;
            leftPointer++;
            rightPointer--;
        }
    }
}
