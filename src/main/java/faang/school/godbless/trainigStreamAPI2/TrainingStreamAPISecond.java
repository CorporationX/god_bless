package faang.school.godbless.trainigStreamAPI2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrainingStreamAPISecond {
    private static final Runnable listError = () -> System.out.println("Переданный список пуст!");

    //Найдите все уникальные пары чисел, сумма которых равна заданному числу
    //Много времени потратил на эту задачу, долго думал, как учесть вариант, когда в списке есть повторы значений и их пару нужно учесть
    //Например, в списке 1, 2, 3, 3, 4 есть две 3, сумма должна быть 6. Вариант 3:3 тоже должен подходить)
    public static Map<Integer, Integer> getUniqueCoupleWhereSumEqualsGiven(List<Integer> numbers, int given) {
        if (numbers == null || numbers.isEmpty()) {
            listError.run();
            return new HashMap<>();
        }

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        numbers.forEach(number -> map.put(number, map.getOrDefault(number, 0) + 1));

        return map.entrySet().stream()
                .filter(entry -> !set.contains(entry.getKey()) &&
                        (map.containsKey(given - entry.getKey()) && entry.getKey() != given - entry.getKey()) ||
                        (map.containsKey(given - entry.getKey()) && map.get(given - entry.getKey()) > 1 && entry.getKey() == given - entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> {
                    set.add(given - entry.getKey());
                    return given - entry.getKey();
                }));
    }

    //На вход получаем мапу с названиями стран и их столицами.
    //Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
    public static List<String> getTheCapitalsList(Map<String, String> countries) {
        if (countries == null || countries.isEmpty()) {
            listError.run();
            return new ArrayList<>();
        }

        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    //Получаем список строк и букву в виде char.
    //Отфильтруйте строки, которые начинаются с заданной буквы, и отсортируйте их по длине в порядке возрастания
    public static List<String> filterStringsByCharAndOrder(List<String> strings, char c) {
        if (strings == null || strings.isEmpty()) {
            listError.run();
            return new ArrayList<>();
        }

        return strings.stream()
                .filter(str -> str.toLowerCase().startsWith(String.valueOf(c).toLowerCase()))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
    //Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
    public static Map<String, List<String>> findMutualFriends(Map<String, List<String>> map) {
        if (map == null || map.isEmpty()) {
            listError.run();
            return new HashMap<>();
        }

        Map<String, List<String>> mapOfMutual = new HashMap<>();

        map.forEach((key, value) -> {
            Set<String> friends = new HashSet<>(map.get(key));
            map.get(key).forEach(friend -> {
                map.getOrDefault(friend, Collections.emptyList()).forEach(mutual -> {
                    if (!friends.contains(mutual) && !key.equals(mutual)) {
                        if (!mapOfMutual.containsKey(key))
                            mapOfMutual.put(key, new ArrayList<>());
                        mapOfMutual.get(key).add(mutual);
                    }
                });
            });
        });

        return mapOfMutual;
    }

    //Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
    // Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.
    public static Map<String, Double> getAverageSalary(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            listError.run();
            return new HashMap<>();
        }

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        //Вот так по началу написал сам, потом узнал, что оказывается можно одной строчкой :)
        /*return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .map(entry -> {
                    double avr = entry.getValue().stream()
                            .mapToDouble(Employee::getSalary)
                            .average().orElse(0.0);
                    return Map.entry(entry.getKey(), avr);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));*/
    }

    //Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита,
    //и отсортируйте их в порядке возрастания длины строк.
    public static List<String> filterStringsByAlphabet(List<String> strings, Set<Character> alphabet) {
        if (strings == null || strings.isEmpty()) {
            listError.run();
            return new ArrayList<>();
        }
        Set<Character> finalAlphabet = alphabet.stream()
                .map(Character::toLowerCase)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(str -> str.chars().allMatch(c -> finalAlphabet.contains(Character.toLowerCase((char) c))))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //Написать метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.
    public static List<String> convertToBinary(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            listError.run();
            return new ArrayList<>();
        }

        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево) в заданном диапазоне.
    //На вход получаем число для начала диапазона и число для второй границы диапазона.
    public static List<Integer> findPalindromeNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(number -> {
                    String str = Integer.toString(number);
                    return str.equals(new StringBuilder(str).reverse().toString());
                })
                .boxed()
                .toList();
    }

    //Написать метод, который найдёт все подстроки в строке, которые являются палиндромами.
    //На вход получаем строку, а вернуть должны список строк.
    public static List<String> findPalindromeSubstrings(String str) {
        return IntStream.range(0, str.length())
                .mapToObj(indexStart -> IntStream.range(indexStart, str.length())
                        .mapToObj(indexEnd -> str.substring(indexStart, indexEnd + 1))
                        .toList())
                .flatMap(Collection::stream)
                .filter(subStr -> subStr.equalsIgnoreCase(new StringBuilder(subStr).reverse().toString()))
                .toList();
    }

    //Написать метод, который найдёт все совершенные числа (сумма делителей числа равна самому числу) в заданном диапазоне.
    //На вход получаем число для начала диапазона и число для второй границы диапазона.
    //Не придумал, как можно исключить 0 из добавления в поток сразу
    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(number ->
                    IntStream.rangeClosed(1, number / 2)
                            .filter(divider -> number % divider == 0)
                            .reduce(0, Integer::sum) == number
                )
                .filter(number -> number != 0)
                .boxed()
                .toList();
    }

    public static void main(String[] args) {
        //уникальные пары чисел, сумма которых равна заданному числу
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 3, 6, 7, 8);
        System.out.println("Уникальные пары чисел, сумма которых равна заданному числу: ");
        getUniqueCoupleWhereSumEqualsGiven(numbers, 6).forEach((key, value) -> System.out.println(key + ": " + value));

        //Отсортируйте страны по алфавиту, а затем выведите названия их столиц
        Map<String, String> map = Map.of("Russia", "Moscow", "USA", "Washington", "Brazil", "Brazilia");
        System.out.println("Столицы по алфавиту: ");
        getTheCapitalsList(map).forEach(System.out::println);

        //Отфильтруйте строки, которые начинаются с заданной буквы, и отсортируйте их по длине в порядке возрастания
        List<String> strings = List.of("hello", "stream", "world", "son", "simple");
        System.out.println("Фильтрация строк:");
        filterStringsByCharAndOrder(strings, 's').forEach(System.out::println);

        //Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
        System.out.println("Общие друзья:");
        Map<String, List<String>> mapOfFriends = Map.of("Egor", List.of("Artem", "Sveta", "Victor"), "Artem", List.of("Egor", "Petr"),
                "Sveta", List.of("Egor"), "Petr", List.of("Artem"));
        findMutualFriends(mapOfFriends).forEach((key, value) -> {
            System.out.println(key + ": ");
            value.forEach(System.out::println);
            System.out.println("----------");
        });

        //Найдите среднюю зарплату для каждого отдела
        List<Employee> employees = List.of(
                new Employee("Egor", "№1", 100.0),
                new Employee("Victor", "№2", 155.5),
                new Employee("Sveta", "№1", 110.0),
                new Employee("Bob", "№1", 200.0),
                new Employee("Artem", "№2", 167.5)
        );
        System.out.println("Средняя зарплата для каждого отдела:");
        getAverageSalary(employees).forEach((key, value) -> System.out.println(key + ": " + value));

        //Отфильтруйте строки, которые содержат только буквы заданного алфавита
        strings = List.of("hello", "lehoo", "world", "son", "simple");
        System.out.println("Фильтрация строк по заданнму алфавиту");
        filterStringsByAlphabet(strings, Set.of('h', 'e', 'l', 'o', 's', 'n')).forEach(System.out::println);

        //Преобразует список целых чисел в список строк в двоичном виде.
        System.out.println("В двоичный вид: ");
        convertToBinary(numbers).forEach(System.out::println);

        //Найти все числа-палиндромы
        System.out.println("Найти все числа-палиндромы: ");
        findPalindromeNumbers(100, 131).forEach(System.out::println);

        //Найти все подстроки-палиндромы
        System.out.println("Найти все подстроки-палиндромы:");
        findPalindromeSubstrings("hollo").forEach(System.out::println);

        //Найти совершенные числа
        System.out.println("Найти совершенные числа:");
        findPerfectNumbers(0, 497).forEach(System.out::println);
    }
}
