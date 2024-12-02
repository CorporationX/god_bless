package school.faang.bjs2_43623;

public class Example {
    public static int[] reverse(int[] input) {
        if (input == null || input.length == 1) {
            return input;
        }

        int[] result = new int[input.length];
        int i = 0;
        int j = input.length - 1;
        while (i < input.length) {
            result[i] = input[j];
            i++;
            j--;
        }

        return result;
    }
}
