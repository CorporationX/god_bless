package school.faang.reverse;

public class Example {
    public static void reverse(int[] array) {
        // Проверка на null
        if (array == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }
        // Проверка на пустой массив или массив из одного элемента
        if (array.length <= 1) {
            return; // Нечего reverse
        }

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}