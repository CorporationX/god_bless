package derschrank.sprint01.task01.bjstwo_43630;

public class ReverseArray {
    public static Object[] doReverse(Object[] array) {
        int sizeOfArray = array.length;
        if (sizeOfArray < 2) {
            return array;
        }
        for (int i = 0; i < sizeOfArray / 2; i++) {
            Object temp = array[i];
            array[i] = array[sizeOfArray - i - 1];
            array[sizeOfArray - i - 1] = temp;
        }
        return array;
    }
}
