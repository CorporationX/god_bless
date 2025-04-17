package school.faang.bjs2_70763;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Operations {
    // Найдите уникальные пары чисел
    // Дано множество (Set) целых чисел и целевое число. Найдите все уникальные пары чисел, сумма которых равна заданному числу.
    // Пример:
    // Вход: [1, 2, 3, 4, 5, 6], целевое число: 6
    // Выход: [(1, 5), (2, 4)]
    public static Set<List<Integer>> findUniquePairs(List<Integer> numbers, Integer target) {
        return numbers.stream()
            .filter(Objects::nonNull)
            .filter(num -> num != target - num && numbers.contains(target - num))
            .map(num -> Arrays.asList(num, target - num))
            .peek(Collections::sort)
            .collect(Collectors.toSet());
    }

    // Отсортируйте страны и выведите столицы
    // На вход получаем Map с названиями стран и их столицами. Отсортируйте страны по алфавиту и верните список названий их столиц.
    // Пример:
    // Вход: {"Russia": "Moscow", "USA": "Washington", "Germany": "Berlin"}
    // Выход: ["Berlin", "Moscow", "Washington"]
    public static List<String> getCapitalBySortedCountry(Map<String, String> countries) {
        return countries.keySet().stream()
            .sorted(String::compareToIgnoreCase)
            .map(countries::get)
            .collect(Collectors.toList());
    }

    // Фильтрация и сортировка строк
    // На вход получаем список строк и символ. Необходимо отфильтровать строки, которые начинаются с заданного символа, и отсортировать их по длине.
    // Пример:
    // Вход: ["apple", "banana", "avocado", "apricot"], символ: 'a'
    // Выход: ["apple", "apricot", "avocado"]
    public static List<String> sortByLength(List<String> words, char startChar) {
        return words.stream()
            .filter(Objects::nonNull)
            .filter(word -> !word.isEmpty() && word.charAt(0) == startChar)
            .sorted(String::compareTo)
            .sorted(Comparator.comparingInt(String::length))
            .toList();
    }

    // Преобразование чисел в двоичный формат
    // Напишите метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.
    // Пример:
    // Вход: [1, 2, 3, 4]
    // Выход: ["1", "10", "11", "100"]

    // Фильтрация строк по алфавиту и сортировка по длине
    // Дан список строк. Необходимо отфильтровать строки, которые содержат только буквы из заданного алфавита, и отсортировать их по длине в порядке возрастания.
    // Пример:
    // Вход: ["apple", "banana", "cherry", "date", "fig", "grape"], алфавит: "abcdefghijklmnopqrstuvwxyz"
    // Выход: ["fig", "date", "apple", "grape", "banana", "cherry"]
}
