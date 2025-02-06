package school.faang.sprint1.task_BJS2_56355;

/**
 * File for test:
 * test/java/school/faang/sprint1/task_BJS2_56355/ExampleTest
 *
 */

public class Example {
    /**
     * Реверсирует порядок элементов в переданном массиве целых чисел.
     * Массив изменяется "на месте", то есть исходный массив будет модифицирован.
     *
     * @param array Массив целых чисел, который необходимо реверсировать.
     *             Не может быть {@code null}.
     * @throws IllegalArgumentException Если переданный массив равен {@code null}.
     */
    public void reverse(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        if (array.length == 0) {
            return;
        }

        int temp;
        int length = array.length;

        for (int i = 0; i < length / 2; i++) {
            temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
    }
}
