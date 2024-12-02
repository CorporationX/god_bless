package school.faang.dec_01;

public class Example {

    public static void reverse(int[] inputArray) {
        int[] arrayWithReversedNumber = new int[inputArray.length];

        int counter = 0;
        for (int i = inputArray.length - 1; i >= 0; i--) {
            arrayWithReversedNumber[counter] = inputArray[i];
            counter++;
        }
    }
}
