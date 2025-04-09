package school.faang.basic.reverse;

import java.util.Arrays;

public class Example {

    public static int[] reverse(int[] input) {
        int pivotIndex;
        int[] output = Arrays.copyOf(input, input.length);

        if (output.length < 2) {
            return output;
        } else if (output.length % 2 == 0) {
            pivotIndex = input.length / 2;
        } else {
            pivotIndex = (input.length - 1) / 2;
        }

        for (int i = 0; i < pivotIndex; i++) {
            int opposite = output[output.length - 1 - i];
            output[output.length - 1 - i] = output[i];
            output[i] = opposite;
        }
        return output;
    }
}