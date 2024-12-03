package school.faang.task_43627;

public class Example {

    public static void reverse(int[] array) {

        for (int fromBegin = 0, fromEnd = array.length - 1;
             fromBegin < array.length / 2;
             fromBegin++, fromEnd--) {
            int tempInt = array[fromBegin];
            array[fromBegin] = array[fromEnd];
            array[fromEnd] = tempInt;
        }
    }
}
