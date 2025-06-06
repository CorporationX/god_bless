package school.faang.bjs2_79232;

public class Example {
    public static int[] reverse(int[] array) {
        int temp;
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}
