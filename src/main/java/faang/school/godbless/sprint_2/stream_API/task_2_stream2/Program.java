package faang.school.godbless.sprint_2.stream_API.task_2_stream2;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 9, 3, 6, 4, 5, 5, 6, 1, 5, 4);
        int targetSum = 10;
        Set<List<Integer>> pairs = findPairsNumbersForSum(numbers, targetSum);
        System.out.printf("Пары чисел дающие в сумме %d: %s\n", targetSum, pairs);
        // [[5, 5], [4, 6], [1, 9], [9, 1], [6, 4]]

        Map<String, String> countryCapitalMap = Map.of("Россия", "Москва", "Бразилия", "Бразилиа", "Индия", "Нью-Дели",
                "Китай", "Пекин", "ЮАР", "Претория", "Беларусь", "Минск", "КНДР", "Пхеньян");
        System.out.println("Столицы стран, отсортированных по алфавиту: ");
        printCapitalsSortedCountries(countryCapitalMap);
        // Минск Бразилиа Нью-Дели Пхеньян Пекин Москва Претория

        List<String> words = List.of("Камилавка", "Лямка", "Камин", "Краска", "Радуга", "Куратор", "Кот");
        char ch = 'К';
        List<String> sortedWords = sortedWords(words, ch);
        System.out.printf("Отфильтрованные и отсортированные по длине список строк: \n%s\n", sortedWords);
        // [Кот, Камин, Краска, Куратор, Камилавка]

        Map<String, List<String>> usersFriensMap = new HashMap<>();
        usersFriensMap.put("Сергей", List.of("Мария", "Екатерина", "Илья", "Марта"));
        usersFriensMap.put("Илья", List.of("Марта", "Иван", "Оливия", "Сергей"));
        usersFriensMap.put("Владимир", List.of("Иван", "Екатерина", "Яромир", "Ирина"));
        usersFriensMap.put("Ирина", List.of("Яромир", "Дмитрий", "Арина", "Екатерина"));

        List<List<String>> pairsPossibleFriends = findPossibleFriends(usersFriensMap);
        System.out.printf("Возможно эти пользователи знакомы: %s\n", pairsPossibleFriends);
        // [[Сергей, Ирина], [Сергей, Владимир], [Илья, Владимир], [Ирина, Сергей], [Ирина, Владимир], [Владимир, Сергей], [Владимир, Илья]]

        List<Employee> employeeList = new ArrayList<>(List.of(
                new Employee("Ivan", 270000, "development"),
                new Employee("Ivan", 200000, "development"),
                new Employee("Serg", 150000, "development"),
                new Employee("Mark", 250000, "QA"),
                new Employee("Liza", 130000, "QA"),
                new Employee("Vova", 120000, "QA"),
                new Employee("Kate", 200000, "hr"),
                new Employee("Marta", 145000, "hr"),
                new Employee("Mary", 100000, "hr")
        ));

        Map<String, Double> averageSalaryByDepartament = calcAverageSalaryByDepatment(employeeList);

        for (String s : averageSalaryByDepartament.keySet()) {
            System.out.printf("Средняя зарплата в департаменте \"%s\": %.2f\n", s, averageSalaryByDepartament.get(s));
        }
        // "QA": 166666,67; "development": 206666,67; "hr": 148333,33;

        List<String> stringList = List.of("apple", "banana", "123", "dog", "cat");
        char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        List<String> filteredStrings = checkStringsByAlphabet(alph, stringList);
        System.out.printf("Список слов, содержащих заданный массив символов: %s\n", filteredStrings);
        // [dog, cat, apple, banana]

        numbers = List.of(1, 2, 3, 4, 5);
        List<String> stringsBiNumbers = numbers.stream().map(Integer::toBinaryString).toList();
        System.out.printf("Список чисел в двоичной системе исчесления: %s\n", stringsBiNumbers);
        // [1, 10, 11, 100, 101]

        List<Integer> palindromeNumbers = findPalindrome(10, 200);
        System.out.printf("Список чисел палинромов: %s\n", palindromeNumbers);
        // [11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111, 121, 131, 141, 151, 161, 171, 181, 191]

        List<Integer> perfectNumbers = findPerfectNumbers(0, 1000);
        System.out.printf("Список совершенных чисел: %s\n", perfectNumbers);
        // [1, 6, 28, 496]

        String text = "olo3olekerekegyyge";
        Set<String> palindromesSet = findPalindromesSubString(text);
        System.out.printf("Множество подстрок полиндромов внутри строки \"%s\": %s", text, palindromesSet);
        // [gyyg, olo, lo3ol, ere, o3o, ekereke, kerek, egyyge, eke]

    }

    private static Set<String> findPalindromesSubString(String text) {
        return IntStream.range(0, text.length())
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i, text.length() - 3)
                        .mapToObj(j -> text.substring(i, j + 3)))
                .filter(Program::isPalindrome)
                .collect(Collectors.toSet());
    }

    private static boolean isPalindrome(String string) {
        String reversedString = new StringBuilder(string).reverse().toString();
        return string.equals(reversedString);
    }

    private static boolean isPalindrome(int num) {
        String number = Integer.toString(num);
        return number.contentEquals(new StringBuilder(number).reverse());
    }

    private static boolean ifPerfect(int number) {
        return IntStream.rangeClosed(1, number / 2 + 1)
                .filter(i -> number % i == 0)
                .sum() == number;
    }

    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(Program::ifPerfect)
                .boxed()
                .toList();
    }

    public static List<Integer> findPalindrome(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(Program::isPalindrome)
                .boxed()
                .toList();
    }

    public static List<String> checkStringsByAlphabet(char[] alph, List<String> stringList) {
        Set<Integer> chars = new String(alph).chars().boxed().collect(Collectors.toSet());

        return stringList.stream()
                .filter(string -> string.chars().allMatch(chars::contains))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    // добавил для себя, чтобы иметь несколько примеров решения задачи
    public static List<String> checkStringsByAlphabetV2(List<String> stringList, List<Character> chars) {
        return stringList.stream()
                .filter(i -> chars.stream()
                        .anyMatch(j -> i.contains(j.toString())))
                .collect(Collectors.toList());
    }

    public static Map<String, Double> calcAverageSalaryByDepatment(List<Employee> employeeList) {
        return employeeList.stream().
                collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
    }

    public static List<List<String>> findPossibleFriends(Map<String, List<String>> usersFriensMap) {
        return usersFriensMap.keySet().stream()
                .flatMap(user -> usersFriensMap.keySet().stream()
                        .filter(otherUser -> !usersFriensMap.get(user).contains(otherUser) && !user.equals(otherUser))
                        .flatMap(otherUser -> {
                            Set<String> commonFriends = new HashSet<>(usersFriensMap.get(user));
                            commonFriends.retainAll(usersFriensMap.get(otherUser));
                            return commonFriends.isEmpty() ? Stream.empty() : Stream.of(List.of(user, otherUser));
                        })).toList();
    }

    public static List<String> sortedWords(List<String> words, char ch) {
        return words.stream()
                .filter(s -> s.charAt(0) == ch)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static void printCapitalsSortedCountries(Map<String, String> countryCapitalMap) {
        countryCapitalMap.keySet().stream()
                .sorted(String::compareTo)
                .forEach(k -> System.out.println(countryCapitalMap.get(k)));
    }

    public static Set<List<Integer>> findPairsNumbersForSum(List<Integer> numbers, int targetSum) {
        return IntStream.range(0, numbers.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, numbers.size())
                        .filter(j -> numbers.get(i) + numbers.get(j) == targetSum)
                        .mapToObj(j -> List.of(numbers.get(i), numbers.get(j)))
                )
                .collect(Collectors.toSet());
    }

}
