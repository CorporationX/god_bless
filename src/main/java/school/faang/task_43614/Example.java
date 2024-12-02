package school.faang.task_43614;

public class Example {
    public static int[] reverse(int[] array) {

        if (array.length != 0) {
            int[] arrayRev = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                arrayRev[i] = array[array.length - 1 - i];
            }
            array = arrayRev;
        }

        return array;
    }
}

