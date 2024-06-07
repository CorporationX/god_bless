package faang.school.godbless.module1.sprint1.task2;



public class Example {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverse(array);

    }

    /**
     * Method: Принимает массив целых чисел и выводит его в консоль наоборот
     * @param: Массив целых чисел
     */
    private static void reverse(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
