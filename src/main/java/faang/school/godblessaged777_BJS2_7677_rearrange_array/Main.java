package faang.school.godblessaged777_BJS2_7677_rearrange_array;

import java.util.Arrays;

public class Main {
    /*

    Условия задачи:
    Создать класс Example. В нём объявить метод, который принимает массив целых чисел в качестве
    параметра и называется reverse. Этот метод должен разворачивать переданный массив.
    Пример: {{nums = [1,2,3,4,5] }}→ reverse(nums) → nums = [5,4,3,2,1].

     */
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5}; // создаём массив

        // демонстрация работы метода
        System.out.println(Arrays.toString(arr1));

        System.out.println(Arrays.toString(Example.reverse(arr1)));
    }
}
