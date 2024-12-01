package school.faang.moduleone.task_43500;

public class Example {

    public static void reverse(int[] source) {
        int first = 0;
        int last = source.length - 1;

        while (first < last) {
            int temp = source[first];
            source[first] = source[last];
            source[last] = temp;
            first++;
            last--;
        }
    }
}
