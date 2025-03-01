package school.faang.reverse;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 7};
        // Выводим исходный массив
        System.out.println("Исходный массив:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Вызываем метод reverse
        Example.reverse(array);

        // Выводим измененный массив
        System.out.println("Массив после reverse:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
