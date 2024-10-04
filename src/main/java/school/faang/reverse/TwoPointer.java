package school.faang.reverse;

public class TwoPointer {
    public static int[] reverse(int[] array) {
        for(int i = 0; i < array.length/2; i++) {
            int num = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = num;
        }
        return array;
    }
}
