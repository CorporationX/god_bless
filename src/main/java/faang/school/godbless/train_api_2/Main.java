package faang.school.godbless.train_api_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 9, 3, 6, 4, 5);
        int targetSum = 10;
        List<List<Integer>> pairs = findPairs(numbers, targetSum);
        System.out.println("Пары чисел: " + pairs);

        System.out.println("==========>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("France", "Paris");
        countriesAndCapitals.put("Germany", "Berlin");
        countriesAndCapitals.put("Italy", "Rome");
        countriesAndCapitals.put("Australia", "Canberra");
        System.out.println("Столицы после сортировки стран по алфавиту: " + sortedCounties(countriesAndCapitals));

        System.out.println("==========>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<String> strings = Arrays.asList("Enter", "Change", "Banana", "Citizen", "Screen");
        char symbol = 'C';
        System.out.println(sortedStrings(strings, symbol));

        System.out.println("==========>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Tom", Arrays.asList("Bob", "Mark", "John"));
        friendsMap.put("Bob", Arrays.asList("Tom", "Mark"));
        friendsMap.put("Mark", Arrays.asList("Tom", "Bob", "John"));
        friendsMap.put("John", Arrays.asList("Tom", "Mark"));
        System.out.println("Пары людей, которые не являются друзьями: " + findNonFriendPairs(friendsMap));

        System.out.println("==========>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Tom", 60_000, "HR"));
        employees.add(new Employee("Bob", 400_000, "IT"));
        employees.add(new Employee("Mark", 65_000, "HR"));
        employees.add(new Employee("John", 375_000, "IT"));
        System.out.println(avgSalaryDepartment(employees));

        System.out.println("==========>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<String> inputStrings = Arrays.asList("apple", "banana", "123", "dog", "cat");
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.println("Отфильтрованные слова из словаря: " + sortStrings(inputStrings, alphabet));

        System.out.println("==========>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<Integer> numbersToBinary = List.of(37, 44, 18, 3, 90, 117);
        System.out.println("Преобразование списка целых чисел в список строк в двоичном виде: "
                + convertToBinary(numbersToBinary));

        System.out.println("==========>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        int start = 0;
        int end = 200;
        System.out.println("Числа палиндромы от " + start + " до " + end + ": " + findPalindromes(start, end));

    }

    private static List<List<Integer>> findPairs(List<Integer> numbers, int targetSum) {
        return numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> !Objects.equals(i, j) && i + j == targetSum)
                        .map(j -> Arrays.asList(i, j))).distinct().toList();
    }

    private static List<String> sortedCounties(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    private static List<String> sortedStrings(List<String> strings, char symbol) {
        return strings.stream().filter(s -> s.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    private static List<String> findNonFriendPairs(Map<String, List<String>> friendsMap) {
        List<String> uniqueFriends = friendsMap.keySet().stream()
                .flatMap(person -> friendsMap.get(person).stream())
                .distinct()
                .toList();

        return friendsMap.keySet().stream()
                .flatMap(f1 -> friendsMap.keySet().stream()
                        .filter(f2 -> !f1.equals(f2) && !friendsMap.get(f1).contains(f2))
                        .filter(f2 -> friendsMap.get(f1).stream().anyMatch(uniqueFriends::contains))
                        .map(f2 -> f1 + " и " + f2))
                .collect(Collectors.toList());
    }

    private static Map<String, Double> avgSalaryDepartment(List<Employee> employees) {
        return employees.stream().
                collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    private static List<String> sortStrings(List<String> inputStrings, char[] alphabet) {
        return inputStrings.stream()
                .filter(str -> str.chars().allMatch(c -> Arrays.binarySearch(alphabet, (char) c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    private static List<String> convertToBinary(List<Integer> numbers){
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    private static List<Integer> findPalindromes(int start, int end){
        return IntStream.rangeClosed(start, end).filter(Main::isPalindrome).boxed().toList();
    }

    private static boolean isPalindrome(int number){
        String num = String.valueOf(number);
        int left = 0;
        int right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
