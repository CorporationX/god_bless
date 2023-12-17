package faang.school.godbless.TrainSteamAPI2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        List<Integer> numbers = Arrays.asList(1, 2, 5, 7, 8, 9, 1, 8, 3, 10, 9, 1, 7, 7, 3);
        Set<List<Integer>> uniquePairs = StreamMethods.uniquePairs(numbers, 10);
        System.out.println("Уникальные значения: " + uniquePairs);

        // Задание 2
        Map<String, String> countryCapital = new HashMap<>();
        countryCapital.put("Russia", "Mosсow");
        countryCapital.put("Austria", "Vienna");
        countryCapital.put("Italy", "Rome");
        countryCapital.put("Belgium", "Brussels");
        countryCapital.put("Japan", "Tokyo");

        List<String> capitalsSort = StreamMethods.capitalsSort(countryCapital);
        System.out.println(capitalsSort);

        // Задание 3
        List<String> words = Arrays.asList("pineapple", "banana", "orange", "pear", "avocado", "potato");
        List<String> sortStringsByLength = StreamMethods.sortStringsByLength(words, 'p');
        System.out.println(sortStringsByLength);

        // Задание 4
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Alice", Arrays.asList("Daniel", "Join", "Emma"));
        friends.put("Jack", Arrays.asList("Bill", "Join", "Eva"));
        friends.put("Emily", Arrays.asList("Lucy", "Olivia", "James")); //нет повторных друзей
        friends.put("Tom", Arrays.asList("Emily", "Join", "Eva"));
        friends.put("Daniel", Arrays.asList("Alice", "Jane", "Eva"));
        Set<List<String>> friendsFriends = StreamMethods.friendsFriends(friends);
        System.out.println("Друзья друзей: " + friendsFriends);

        // Задание 5
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Сергей", 40000, "отдел работ"));
        employees.add(new Employee("Алёна", 50000, "отдел работ"));
        employees.add(new Employee("Василий", 60000, "отдел работ"));
        employees.add(new Employee("Iгорь", 20000, "отдел закупок"));
        employees.add(new Employee("Лидия", 120000, "отдел закупок"));

        Map<String, Double> averageDepartmentSalary = StreamMethods.averageDepartmentSalary(employees);
        System.out.println(averageDepartmentSalary);

        // Задание 6
        List<String> strings = Arrays.asList("hello", "house", "home", "pineapple", "banana", "orange", "ho");
        List<Character> characters = List.of('h', 'e', 'l', 'o', 'm');
        List<String> sortStringsOfLetters = StreamMethods.sortStringsOfLetters(strings, characters);
        System.out.println(sortStringsOfLetters);

        // Задание 7
        List<String> convertsIntToBinary = StreamMethods.convertsIntToBinary(numbers);
        System.out.println("Задача 7: " + convertsIntToBinary);

        // Задание 8
        StreamMethods.searchIntPalindrome(1, 150).forEach(System.out::println);

        // Задание  9
        String stringWithPalindrom = "Madam has moved to the next level";
        List<String> searchStringPalindrome = StreamMethods.searchStringPalindrome(stringWithPalindrom);
        System.out.println("Слова-палиндромы: " + searchStringPalindrome);
    }
}
