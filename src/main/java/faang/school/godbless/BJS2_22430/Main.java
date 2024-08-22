package faang.school.godbless.BJS2_22430;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> inputList = List.of(1, 9, 3, 5, 6, 4, 5);
        int targetSum = 10;
        System.out.println("Unique pairs:");
        System.out.println(uniquePairs(inputList, targetSum));

        Map<String, String> countries = new HashMap<>() {{
            put("USA", "Washington");
            put("Germany", "Berlin");
            put("France", "Paris");
            put("Switzerland", "Berna");
            put("New Zealand", "Wellington");
        }};

        System.out.println("Countries sort:");
        System.out.println(countrySort(countries));

        System.out.println("Strings sort:");
        List<String> strings = List.of("Word", "Hello", "World", "Another word", "Hello world", "Hi world", "Hi world!", "Some word");
        System.out.println(stringsSort(strings, 'H'));

        System.out.println("Find friends:");
        List<String> mariaFriends = List.of("John", "Markus", "Jimmy");
        List<String> michaelFriends = List.of("Nancy", "Sarah", "Tiffany");
        List<String> richardFriends = List.of("Markus", "Amber", "Jack");
        List<String> patrickFriends = List.of("Philip", "Tom", "Sarah");

        Map<String, List<String>> friendsMap = new HashMap<>() {{
            put("Maria", mariaFriends);
            put("Michael", michaelFriends);
            put("Richard", richardFriends);
            put("Patrick", patrickFriends);
        }};
        System.out.println(findFriends(friendsMap));
        System.out.println("Find avg salary by department");
        List<Employee> employees = List.of(
                new Employee("John", 200, "IT"),
                new Employee("Nancy", 250, "Marketing"),
                new Employee("Markus", 150, "Sales"),
                new Employee("Sarah", 310, "Sales"),
                new Employee("Jack", 180, "Marketing"),
                new Employee("Jessica", 270, "IT")
        );
        System.out.println(avgSalaryByDepartment(employees));

        System.out.println("String only in alphaber: ");
        List<String> stringsList = List.of("apple", "banana", "123", "dog", "cat", "!some", "wor#d");
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        System.out.println(stringAlphabetSort(stringsList, alphabet));
        System.out.println("Convert list int to list strings:");
        List<Integer> nums = List.of(4, 45, 2455, 2, 34, 25, 6, 3, 8, 43, 14);
        System.out.println(decimalIntToBinaryString(nums));
        System.out.println("Find palindrome");
        System.out.println(findPalindrome(0, 200));
    }

    public static List<Integer> findPalindrome(int startBorder, int endBorder) {
        List<Integer> nums = Stream.iterate(startBorder, num -> num + 1)
                .limit(++endBorder - startBorder)
                .toList();

        return nums.stream()
                .filter(n -> String.valueOf(n).contentEquals(new StringBuilder(Integer.toString(n)).reverse()) &&
                        String.valueOf(n).length() > 1)
                .toList();
    }

    public static List<String> decimalIntToBinaryString(List<Integer> nums) {
        return nums.stream()
                .map(num -> Integer.toBinaryString(num))
                .toList();
    }

    public static Set<Pair<Integer, Integer>> uniquePairs(List<Integer> inputList, int targetSum) {
        return inputList.stream()
                .flatMap(outerNum -> inputList.stream()
                        .filter(innerNum -> innerNum + outerNum == targetSum && (outerNum > innerNum || outerNum.equals(innerNum)))
                        .map(innerNum -> new Pair<>(outerNum, innerNum)))
                .collect(Collectors.toSet());
    }

    public static List<String> countrySort(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> stringsSort(List<String> strings, char symbol) {
        return strings.stream().filter(string -> string.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static Set<Set> findFriends(Map<String, List<String>> friends) {
        return friends.keySet().stream()
                .flatMap(person1 -> friends.keySet().stream()
                        .filter(person2 -> friends.get(person1).stream().anyMatch((friends.get(person2)::contains)) && !person2.equals(person1))
                        .map(p2 -> new TreeSet() {{
                            add(person1);
                            add(p2);
                        }})
                )
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> avgSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy((Employee::getDepartment), Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> stringAlphabetSort(List<String> strings, char[] alphabet) {
        Set<Character> alphabetChars = IntStream.range(0, alphabet.length)
                .mapToObj(ch -> alphabet[ch])
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(string -> string.chars()
                        .allMatch(ch -> alphabetChars.contains((char) ch))
                )
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
