package faang.school.godbless.BJS2_10673;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 9, 3, 6, 4, 5, 5, 5, 9);

        Map<String, String> countriesAndCapitals = Map.of(
                "Great Britain", "London",
                "Japan", "Tokyo",
                "Russia", "Moscow",
                "Germany", "Berlin",
                "France", "Paris",
                "Australia", "Sydney");

        List<String> strings = List.of("first", "second", "third", "123", "fourth", "fifth", "sixth");

        Character[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        Employee employee1 = new Employee("Vasya", 10000, "Dev");
        Employee employee2 = new Employee("Kolya", 20000, "QA");
        Employee employee3 = new Employee("Petya", 30000, "QA");
        Employee employee4 = new Employee("Sergey", 40000, "HR");
        Employee employee5 = new Employee("Anna", 50000, "HR");
        Employee employee6 = new Employee("Kate", 60000, "Dev");
        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5, employee6);

        Map<String, List<String>> friends = new HashMap<>();
        friends.put("n1", List.of("n2", "n3"));
        friends.put("n2", List.of("n3", "n4"));
        friends.put("n3", List.of("n1", "n2"));
        friends.put("n4", List.of("n1", "n2"));


        System.out.println(findPairs(numbers, 10));
        sortAndPrintCapitals(countriesAndCapitals);
        System.out.println(filterAndSortStringsByKey(strings, 'f'));
        System.out.println(generateReportAverageSalaryByDepartment(employees));
        System.out.println(filterByConditionAndSortByLength(strings, alphabet));
        System.out.println(convertListDecimalToBinary(numbers));
        System.out.println(palindromesInBounds(-50, 500));
        System.out.println(findPairsWithSameFriends(friends));
    }

    //найти уникальные пары чисел, сумма которых равна заданному числу
    public static Map<Integer, Integer> findPairs(List<Integer> numbers, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        numbers.forEach(n -> {
            if (!map.containsValue(n)) {
                int m = sum - n;
                if ((n != m) || (numbers.stream()
                        .filter(count -> count.equals(n)).count() >= 2)) {
                    map.putIfAbsent(n, m);
                }
            }
        });
        return map.entrySet().stream()
                .filter(entry -> numbers.contains(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    //вывести названия столиц стран, отсортированных по алфавиту
    public static void sortAndPrintCapitals(Map<String, String> countriesAndCapitals) {
        countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(n -> System.out.println(n.getValue()));
    }

    //получить список строк, которые начинаются с заданной буквы и отсортированы по возрастанию длины
    public static List<String> filterAndSortStringsByKey(List<String> strings, char key) {
        return strings.stream()
                .filter(n -> n.regionMatches(false, 0, Character.toString(key), 0, 1))
                .sorted(String::compareTo)
                .toList();
    }

    //найти пары людей, которые не являются друзьями, но есть общие друзья
    public static Map<String, String> findPairsWithSameFriends(Map<String, List<String>> friends) {
        Map<String, String> result = new HashMap<>();
        List<String> allPeople = new ArrayList<>(friends.keySet());
        for (int i = 0; i < allPeople.size() - 1; i++) {
            String firstFriend = allPeople.get(i);
            String secondFriend = allPeople.get(i + 1);
            int finalI = i;
            friends.entrySet().stream()
                    .filter(n -> (!friends.get(firstFriend).contains(secondFriend)) &&
                            (!friends.get(secondFriend).contains(firstFriend)) &&
                            (friends.get(firstFriend).stream()
                                    .anyMatch(n1 -> friends.get(secondFriend).stream()
                                            .anyMatch(n1::equals))))
                    .forEach(entry -> result.put("пара " + finalI, firstFriend + " " + secondFriend));
        }
        return result;
    }

    //из листа с персоналом сделать мапу с названием отдела и средней зарплатой
    public static Map<String, Double> generateReportAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    //отфильтровать строки, содержащие только буквы заданного алфавита, отсортировать по возрастанию длины
    public static List<String> filterByConditionAndSortByLength(List<String> strings, Character[] alphabet) {
        Set<Character> alphabetSet = new HashSet<>(Arrays.asList(alphabet));
        return strings.stream()
                .filter(n -> n.chars().allMatch(m -> alphabetSet.contains((char) m)))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    //конвертация списка чисел в список строк со значением этих чисел в двоичном представлении
    public static List<String> convertListDecimalToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //найти все числа-палиндромы в заданном диапазоне
    public static List<Integer> palindromesInBounds(int startBound, int endBound) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < endBound - startBound + 1; i++) {
            numbers.add(startBound + i);
        }
        return numbers.stream()
                .filter(n -> n > 10)
                .filter(n -> String.valueOf(n).contentEquals(new StringBuilder(String.valueOf(n)).reverse()))
                .toList();
    }
}