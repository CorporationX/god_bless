package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");
        List<Integer> numsList = List.of(1, 9, 3, 6, 4, 5);
//        findUniqPair(numsList, 10);
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000, "IT"),
                new Employee("Bob", 60000, "IT"),
                new Employee("Charlie", 70000, "HR"),
                new Employee("David", 55000, "HR"),
                new Employee("Eve", 80000, "Sales"),
                new Employee("Frank", 65000, "Sales")
        );
        System.out.println(findAvarageSalary(employees));

    }

    public static void findUniqPair(List<Integer> list, int a) {
        list.stream()
                .flatMap(i -> list.stream()
                        .filter(j -> !i.equals(j) && i < j && i + j == a)
                        .map(j -> i + " + " + j + " = " + a)
                )
                .distinct()
                .forEach(System.out::println);
    }

    public static void sortCountries(Map<String, String> map) {
        map.entrySet().stream().sorted((c1, c2) -> c1.getKey().compareTo(c2.getKey())).map(Map.Entry::getValue).forEach(System.out::println);
    }

    public static List<String> filterAndSortList(List<String> list, Character a) {
        return list.stream().filter(string -> string.startsWith(String.valueOf(a)))
                .sorted((b, c) -> {
                    if (b.length() > c.length()) {
                        return 1;
                    } else if (c.length() > b.length()) {
                        return -1;
                    }else return 0;
                }).toList();
    }

    public static List<String> findNonFriendsWithCommonFriends(Map<String, List<String>> friendsMap) {
        return friendsMap.keySet().stream()
                .flatMap(person1 -> friendsMap.keySet().stream()
                        .filter(person2 -> !person1.equals(person2) && !friendsMap.get(person1).contains(person2))
                        .filter(person2 -> hasCommonFriends(person1, person2, friendsMap))
                        .map(person2 -> person1 + " и " + person2 + " не друзья, но имеют общих друзей"))
                .distinct()
                .collect(Collectors.toList());
    }

    private static boolean hasCommonFriends(String person1, String person2, Map<String, List<String>> friendsMap) {
        return friendsMap.get(person1).stream()
                .anyMatch(friend -> friendsMap.get(person2).contains(friend));
    }


    public static Map<String, Double> findAvarageSalary(List<Employee> list){
       return list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,                       // Группируем по отделу
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list2 -> {
                                    double sum = list2.stream().mapToDouble(Employee::getSalary).sum();
                                    long count = list2.size();
                                    return sum / count;
                                }
                        )
                ));
    }

    public static List<String> filterAndSortStrings(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(ch -> alphabet.indexOf(ch) >= 0)) // Фильтрация строк, содержащих только буквы заданного алфавита
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))     // Сортировка по длине строк
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinaryStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)  // Преобразуем каждое число в строку с его двоичным представлением
                .collect(Collectors.toList()); // Собираем результат в список строк
    }

    private static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }

    // Метод для нахождения всех чисел-палиндромов в заданном диапазоне
    public static List<Integer> findPalindromesInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)  // Генерация чисел в диапазоне [start, end]
                .filter(number->{
                    String str = Integer.toString(number);
                    String reversedStr = new StringBuilder(str).reverse().toString();
                    return str.equals(reversedStr);
                })  // Фильтрация чисел, которые являются палиндромами
                .boxed()  // Преобразование из IntStream в Stream<Integer>
                .collect(Collectors.toList());  // Сбор результатов в список
    }

}