package school.faang.moduleone.turnaround;

public class Example {
    public static int[] reverse(int[] source) {
        int[] reversedArray = new int[source.length];
        for (int i = source.length - 1; i >= 0; i--) {
            reversedArray[source.length - 1 - i] = source[i];
        }
        return reversedArray;
    }

    public static int[] reverseWithoutAdditionalArray(int[] source) {
        int first = 0;
        int last = source.length - 1;

        while (first < last) {
            int temp = source[first];
            source[first] = source[last];
            source[last] = temp;
            first++;
            last--;
        }

        return source;
    }
}
