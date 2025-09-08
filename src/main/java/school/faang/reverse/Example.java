package school.faang.reverse;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        reverse(nums);
        printArray(nums);
    }

    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int value = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = value;
        }
    }

    @SuppressWarnings({"checkstyle:EmptyLineSeparator", "checkstyle:WhitespaceAround"})
    public static void printArray(int[] array) {
        Arrays.stream(array).mapToObj(numsArray -> numsArray + " ").forEach(System.out::print);
    }
}