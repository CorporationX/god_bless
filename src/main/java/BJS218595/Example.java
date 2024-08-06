package BJS218595;

public class Example {
    public static int[] reverse2(int[] array) { //это вариант с For-each который используется в main
        int index = array.length - 1;
        int[] reversedArray = new int[array.length];
        for (int element : array) {
            reversedArray[index--] = element;
        }
        return reversedArray;
    }
}
