package school.faang.m1.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
    2️⃣ Отсортируйте страны и выведите столицы
    На вход получаем Map с названиями стран и их столицами.
    Отсортируйте страны по алфавиту и верните список названий их столиц.

    Пример:

    Вход: {"Russia": "Moscow", "USA": "Washington", "Germany": "Berlin"}
    Выход: ["Berlin", "Moscow", "Washington"]
 */
public class MapOperations {
    public static void main(String[] args) {
        Map<String, String> countries = new HashMap<>(Map.of("Russia", "Moscow", "USA", "Washington",
                "Germany", "Berlin"));
        System.out.println(getCitiesSortedByCountries(countries));

        HashSet<String> filtered = new HashSet<>(Set.of("apple", "banana", "avocado", "apricot"));
        System.out.println(filterAndSortByLength(filtered, 'a'));

        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4));
        System.out.println(binaryRepresentation(numbers));

        String aplhavet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(filerByAlphavetSortByLength(List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                aplhavet));
    }

    public static Set<String> getCitiesSortedByCountries(Map<String, String> countries) {
        return countries
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    /*
        3️⃣ Фильтрация и сортировка строк
        На вход получаем список строк и символ.
        Необходимо отфильтровать строки, которые начинаются с заданного символа, и отсортировать их по длине.

        Пример:

        Вход: ["apple", "banana", "avocado", "apricot"], символ: 'a'
        Выход: ["apple", "apricot", "avocado"]
     */
    public static List<String> filterAndSortByLength(Set<String> countries, char a) {
        return countries
                .stream()
                .filter(s -> s.charAt(0) == a)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    /*
    4️⃣ Преобразование чисел в двоичный формат
    Напишите метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.

    Пример:

    Вход: [1, 2, 3, 4]
    Выход: ["1", "10", "11", "100"]
 */
    public static List<String> binaryRepresentation(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }

    /*
        5️⃣ Фильтрация строк по алфавиту и сортировка по длине
        Дан список строк. Необходимо отфильтровать строки, которые содержат только буквы из заданного алфавита,
        и отсортировать их по длине в порядке возрастания.

        Пример:

        Вход: ["apple", "banana", "cherry", "date", "fig", "grape"], алфавит: "abcdefghijklmnopqrstuvwxyz"
        Выход: ["fig", "date", "apple", "grape", "banana", "cherry"]
     */

    public static List<String> filerByAlphavetSortByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}



