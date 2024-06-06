package faang.school.godblessaged777_BJS2_7677_rearrange_array;

public class Example {
    /**
     * Метод возвращает переданный массив типа int в обратном порядке
     * @param inputArray - входной массив
     * @return - возвращаемый массив
     */
    public static int[] reverse(int[] inputArray) {
        int[] reversedArray = new int[inputArray.length];
        for (int i = 0; i < reversedArray.length; i++) {
            reversedArray[i] = inputArray[inputArray.length - i - 1];
        }
        return reversedArray;
    }
}
