package school.faang.reverse;

public class Example {
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

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        // Выводим исходный массив
        System.out.println("Исходный массив:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Вызываем метод reverse
        reverse(array);

        // Выводим измененный массив
        System.out.println("Массив после reverse:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}