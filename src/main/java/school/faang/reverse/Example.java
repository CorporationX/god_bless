package school.faang.reverse;

public class Example {
    /**
     * Реверсирует порядок элементов в указанном массиве.
     *
     * @param array Массив целых чисел, который необходимо реверсировать.
     *              Если массив пуст, метод завершает выполнение без изменений.
     * @throws IllegalArgumentException Если переданный массив равен {@code null}.
     * @example <pre>
     * int[] arr = {1, 2, 3, 4, 5};
     * reverse(arr); // arr теперь равен {5, 4, 3, 2, 1}
     * </pre>
     */
    public static void reverse(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        if (array.length == 0) {
            return;
        }

        int temp;
        int length = array.length - 1;

        for (int i = 0; i <= length / 2; i++) {
            temp = array[i];
            array[i] = array[length - i];
            array[length - i] = temp;
        }
    }
}