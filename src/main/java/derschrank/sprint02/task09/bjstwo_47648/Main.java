package derschrank.sprint02.task09.bjstwo_47648;


import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StreamApi2Interface api = new StreamApi2();
        System.out.println("1. Найдите уникальные пары чисел");
        System.out.println("Вход: [1, 2, 3, 4, 5, 6], целевое число: 7 ");
        System.out.println("Выход: [(1, 6), (2, 5), (3, 4)]");
        System.out.println("Fact: " + api.findSum(List.of(1, 2, 3, 4, 5, 6), 7));
        System.out.println("Fact: " + api.findSum(List.of(1, 2, 3, 4, 5, 6), 6));

        System.out.println("\n2. Отсортируйте страны и выведите столицы");
        System.out.println("Вход: {Russia: Moscow, USA: Washington, Germany: Berlin}");
        System.out.println("Выход: [Berlin, Moscow, Washington]");
        System.out.println("Fact: " + api
                .sortCountryAndGetCapital(
                        Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")
                )
        );

        System.out.println("\n3. Фильтрация и сортировка строк");
        System.out.println("Вход: [apple, banana, avocado, apricot], символ: 'a'");
        System.out.println("Выход: [apple, apricot, avocado]");
        System.out.println("Fact: " + api
                .findCharAndSortStrings(
                        List.of("apple", "banana", "avocado", "apricot"), 'a')
        );

        System.out.println("\n4. Преобразование чисел в двоичный формат");
        System.out.println("Вход: [1, 2, 3, 4]");
        System.out.println("Выход: [1, 10, 11, 100]");
        System.out.println("Fact: " + api
                .makeDecToBin(List.of(1, 2, 3, 4)));

        System.out.println("\n5. Фильтрация строк по алфавиту и сортировка по длине");
        System.out.println("Вход: [apple, banana, cherry, date, fig, grape], алфавит: abcdefghijklmnopqrstuvwxyz");
        System.out.println("Выход: [fig, date, apple, grape, banana, cherry]");
        System.out.println("Fact: " + api
                .filterStringsByAlphabetAndSortByLength(
                        List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                        "abcdefghijklmnopqrstuvwxyz")
        );
    }
}
