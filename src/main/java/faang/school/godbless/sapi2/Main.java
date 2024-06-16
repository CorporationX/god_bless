package faang.school.godbless.sapi2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final List<Integer> NUMS = List.of(1, 9, 3, 6, 4, 5);
    private static final int SUM = 10;
    private static final Map<String, String> COUNTRIES = Map.of("Россия", "Москва", "Польша", "Варшава",
            "Великобритания", "Лондон", "Австрия", "Вена");
    private static final List<String> STRINGS = List.of("Бывают в жизни огорчения", "Есть большие яблоки", "Было");
    private static final char START_CHAR = 'Б';
    private static final Map<String, List<String>> FRIENDS = Map.of("Дима", List.of("Саша", "Коля"),
            "Антон", List.of("Даня", "Саша"));
    private static final List<Employee> EMPLOYEES = List.of(
            new Employee("Миша", 14000, "1 отдел"),
            new Employee("Саша", 10000, "1 отдел"),
            new Employee("Дима", 13000, "2 отдел"),
            new Employee("Даня", 12000, "1 отдел"),
            new Employee("Олег", 23000, "2 отдел"));
    private static final List<String> LIST_FOR_ALPHABET = List.of("apple", "banana", "123", "dog", "cat");
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final int START_NUM = 10;
    private static final int FINISH_NUM = 50;
    private static final int STEP = 1;

    public static void main(String[] args) {
        // 1
        uniquePairNums(NUMS, SUM).forEach(System.out::println);
        // 2
        getCapitalsOfCountries(COUNTRIES).forEach(System.out::println);
        // 3
        filterStringsChar(STRINGS, START_CHAR).forEach(System.out::println);
        // 4
        pairsNotFriends(FRIENDS).entrySet().forEach(System.out::println);
        // 5
        averageSalaryForDepartment(EMPLOYEES).entrySet().forEach(System.out::println);
        // 6
        Set<Character> alphabet = new String(ALPHABET).chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());
        filterStringsAlphabet(LIST_FOR_ALPHABET, alphabet).forEach(System.out::println);
        // 7
        numsToStringBinary(NUMS).forEach(System.out::println);
        // 8
        findPalindromes(START_NUM, FINISH_NUM).forEach(System.out::println);

    }

    //    Найдите все уникальные пары чисел, сумма которых равна заданному числу
    public static List<List<Integer>> uniquePairNums(List<Integer> nums, int sum) {
        return nums.stream()
                .flatMap(x -> nums.stream()
                        .filter(y -> x + y == sum)
                        .filter(y -> !x.equals(y))
                        .map(y -> Arrays.stream(new Integer[]{x, y})
                                .sorted()
                                .toList()))
                .distinct()
                .toList();
    }

    //    Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка
    public static List<String> getCapitalsOfCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    //    Отфильтруйте строки, которые начинаются с заданной буквы, и отсортируйте их по длине
    //    в порядке возрастания, и верните список этих строк
    public static List<String> filterStringsChar(List<String> strings, char s) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(s)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //    Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
    //    Считаем, что все имена уникальные
    public static Map<String, String> pairsNotFriends(Map<String, List<String>> map) {
        Map<String, String> result = new HashMap<>();
        map.forEach((user, friends) -> map.forEach((another, anotherFriends) -> {
            if (!user.equals(another) && !friends.contains(another)) {
                friends.stream()
                        .filter(anotherFriends::contains)
                        .findFirst()
                        .ifPresent(friend -> result.put(user, another));
            }
        }));
        return result;
    }

    //    Найдите среднюю зарплату для каждого отдела
    public static Map<String, Double> averageSalaryForDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::Department,
                        Collectors.averagingDouble(Employee::salary)
                ));
    }

    //    Отфильтруйте строки, которые содержат только буквы заданного алфавита,
    //    и отсортируйте их в порядке возрастания длины строк
    public static List<String> filterStringsAlphabet(List<String> strings, Set<Character> alphabet) {
        return strings.stream()
                .filter(str -> str.chars()
                        .allMatch(character -> alphabet.contains((char) character)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //    Написать метод, который преобразует список целых чисел в список строк,
    //    где каждое число записано в двоичном виде
    public static List<String> numsToStringBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //    Написать метод, который найдет все числа-палиндромы в заданном диапазоне
    public static List<Integer> findPalindromes(int start, int finish) {
        return Stream.iterate(start, n -> n + STEP).limit(finish - start)
                .filter(num -> {
                    String str = String.valueOf(num);
                    String reverseStr = new StringBuilder(str)
                            .reverse()
                            .toString();
                    return str.equals(reverseStr);
                }).toList();
    }
}
