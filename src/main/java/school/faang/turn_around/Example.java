package school.faang.turn_around;

public class Example {

    public static int[] reverse(int[] array) {

        if (array == null || array.length <= 1) {
            return array;
        }


        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        /*
        Альтернатива:
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        */

        return array;
    }
}
