package school.faang.task_43674;

public class Example {
    public static int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int step = array.length - i - 1;
            int temp = array[i];
            array[i] = array[step];
            array[step] = temp;
        }
        return array;
    }
}
