package faang.school.godbless.turnaround;

public class Example {
    public static void reverse(int[] array) {
        int rightIndex;
        int temp;

        for (int leftIndex = 0; leftIndex < array.length / 2; leftIndex++) {
            rightIndex = array.length - leftIndex - 1;

            temp = array[leftIndex];
            array[leftIndex] = array[rightIndex];
            array[rightIndex] = temp;
        }
    }
}
