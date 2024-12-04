package school.faang.sprint1.bjs_43638;

public class Example {
    public int[] reverse(int[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - 1 - i];
        }

        return result;
    }
}
