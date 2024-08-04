package BJS218595;

public class Example {

    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            array[i] = array[i] + array[array.length - i - 1];
            array[array.length - i - 1] = array[i] - array[array.length - i - 1];
            array[i] = array[i] - array[array.length - i - 1];
        }
    }
    public static int[] reverse2(int[] array) {
        int index = array.length - 1;
         int[] reversedArray = new int[array.length];
        for (int element : array) {
            reversedArray[index--] = element;
        }
        return reversedArray;
    }
}
