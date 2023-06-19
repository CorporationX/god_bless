package faang.school.godbless.reverse;

public class Example {

    public static void reverse(int[] inputArray) {
        if (inputArray == null) {
            return;
        }
        int i = 0;
        int j = inputArray.length - 1;
        while (i < j) {
            int tmp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = tmp;
            i++;
            j--;
        }

    }

    public static int[] reverseToNewArray(int[] inputArray) {
        int[] result;
        if (inputArray == null) {
            return new int[]{};
        }
        result = new int[inputArray.length];
        for (int i = inputArray.length - 1, j = 0;
             i >= 0;
             i--, j++) {
            result[j] = inputArray[i];
        }
        return result;
    }
}
