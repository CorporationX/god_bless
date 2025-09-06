package school.faang.reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Тест 1
        int[] numbers = {1, 2, 3, 4, 5};
        Example.reverse(numbers);

        System.out.print("Тест 1 - Result: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Тест 2 Пустой массив
        int[] array2 = {};
        Example.reverse(array2);
        System.out.println("Тест 2: " + Arrays.toString(array2));

        // Тест 3: Массив одного элемента
        int[] array3 = {42};
        Example.reverse(array3);
        System.out.println("Тест 3: " + Arrays.toString(array3));

        // Тест 4: null (исключение)
        try {
            Example.reverse(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Тест 4: " + e.getMessage());
        }
    }
}