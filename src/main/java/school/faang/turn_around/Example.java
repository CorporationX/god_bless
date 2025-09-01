package school.faang.turn_around;

public class Example {

    public static int[] reverse(int[] array) {

        int[] result = new int[array.length];
        int index = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            result[index] = array[i];
            index++;
        }

        return result;
    }
}
