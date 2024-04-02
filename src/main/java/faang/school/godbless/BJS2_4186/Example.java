package faang.school.godbless.BJS2_4186;

public class Example {

    public static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        //Перебираем array с конца к началу и копируем элементы в reversedArray
        for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
            reversedArray[j] = array[i];
        }
        return reversedArray;
    }
}
