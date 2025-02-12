package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Задача Регистрация пользователей
        User ivan = new User("Ivan", 22, "Uber", "London");
        try {
            User kid = new User("Matthew", 16, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.printf("Вывод данных пользователя: %s \n", ivan);
        
        // Задача Развернись
        List<int[]> list = new ArrayList<>();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arrayNull = null;
        int[] arrayOneElement = {7};
        Collections.addAll(list, array, arrayNull, arrayOneElement);

        for (int[] element : list) {
            try {
                System.out.printf("Исходный массив: %s \n", Arrays.toString(element));
                System.out.printf("Полученный массив: %s \n", Arrays.toString(Example.reverse(element)));
            } catch (IllegalArgumentException e) {
                System.out.printf("Ошибка: %s \n", e.getMessage());
            }
        }
    }
}
