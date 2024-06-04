package faang.school.godbless.reverse;

import lombok.ToString;

@ToString
public class Example {
    public static void reverse(int[] array) {
        int arraySize = array.length;
        int[] reverseArrays = new int[arraySize];
        for (int number : array) {
            arraySize = arraySize - 1;
            reverseArrays[arraySize] = number;
        }
        for (int numbers : reverseArrays) {
            System.out.print(numbers + ", ");
        }
    }
}
