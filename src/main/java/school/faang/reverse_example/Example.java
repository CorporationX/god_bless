package school.faang.reverse_example;

public class Example {
    public static void reverse(int[] list) {
        int leftPointer = 0;
        int rightPointer = list.length - 1;

        while (leftPointer <= rightPointer) {
            int temp = list[leftPointer];
            list[leftPointer] = list[rightPointer];
            list[rightPointer] = temp;

            leftPointer++;
            rightPointer--;
        }
    }
}
