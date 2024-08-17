package faang.school.godbless.BJS2_22455;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 9, 3, 6, 4, 5);
        System.out.println(listOfPairs(numbers, 10));

        Map<String, String> countries = new HashMap<>();
        countries.put("Kyrgyzstan", "Bishkek");
        countries.put("Kazakhstan", "Astana");
        countries.put("Uzbekistan", "Tashkent");
        countries.put("Russia", "Moscow");
        countries.put("Turkey", "Ankara");
        System.out.println(cities(countries));

        List<String> southPark = List.of("Kyle", "Stan", "Kenny", "Eric", "Wendy", "Scott");
        System.out.println(sortedListByLetter(southPark, 'K'));

        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Kyle", List.of("Stan", "Kenny", "Eric"));
        friends.put("Wendy", List.of("Stan", "Kenny"));
        friends.put("Eric", List.of("Stan", "Kenny"));
        friends.put("Scott", List.of("Michael", "Robin"));
        System.out.println(friendsPair(friends));

        List<Employee> employees = List.of(new Employee("Edward", 5000, "IT"),
                new Employee("Michael", 1000, "IT"),
                new Employee("Richard", 2000, "Accounting"),
                new Employee("Rebekka", 8000, "Accounting"));
        System.out.println(averageSalaryByDepartment(employees));

        List<String> words = List.of("kyle", "stan", "kenny", "eric");
        char[] alphabet = {'k', 'e', 'y', 'l', 'n'};
        System.out.println(filterAndSort(words, alphabet));

        System.out.println(toBinary(numbers));

        System.out.println(palindromeNumbers(1, 111));

    }

    public static List<List<Integer>> listOfPairs(List<Integer> numbers, int goal) {
        checkEmpty(numbers);
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return numbers.stream()
                .map(number -> List.of(number, goal - number))
                .filter(pair -> uniqueNumbers.contains(pair.get(0)) && uniqueNumbers.contains(pair.get(1)))
                .filter(pair -> pair.get(0) < pair.get(1))
                .collect(Collectors.toList());
    }

    public static List<String> cities(Map<String, String> countries) {
        if (countries == null || countries.isEmpty()) {
            throw new IllegalArgumentException("Invalid countries");
        }
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> sortedListByLetter(List<String> list, char letter) {
        checkEmpty(list);
        return list.stream()
                .filter(word -> word.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();

    }

    public static List<List<String>> friendsPair(Map<String, List<String>> friends) {
        if (friends == null || friends.isEmpty()) {
            throw new IllegalArgumentException("Invalid map");
        }

        return friends.keySet().stream()
                .flatMap(friend -> friends.keySet().stream()
                        .filter(friend2 -> !friend.equals(friend2))
                        .filter(friend2 -> !friends.get(friend).contains(friend2))
                        .filter(friend2 -> !Collections.disjoint(friends.get(friend), friends.get(friend2)))
                        .map(friend2 -> List.of(friend, friend2)))
                .collect(Collectors.toList());
    }

    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        checkEmpty(employees);
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
    }

    public static List<String> filterAndSort(List<String> words, char[] alphabet) {
        checkEmpty(words);
        Set<Character> letters = new HashSet<>();
        for (char c : alphabet) {
            letters.add(c);
        }
        return words.stream()
                .filter(word -> word.chars().allMatch(c -> letters.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinary(List<Integer> numbers) {
        checkEmpty(numbers);
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> palindromeNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(number -> {
                    String strNumber = String.valueOf(number);
                    return strNumber.contentEquals(new StringBuilder(strNumber).reverse());
                })
                .boxed()
                .toList();
    }

    public static <T> void checkEmpty(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
    }
}
