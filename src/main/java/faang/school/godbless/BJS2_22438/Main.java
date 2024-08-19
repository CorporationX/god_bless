package faang.school.godbless.BJS2_22438;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static List<List<Integer>> createUniquePairsBySumValue(List<Integer> nums, int sumValue) {
        return nums.stream()
                .distinct()
                .flatMap(a -> nums.subList(nums.indexOf(a), nums.size()).stream()
                        .filter(b -> a != b)
                        .map(b -> List.of(a, b))
                        .filter(pair -> pair.get(0) + pair.get(1) == sumValue))
                .toList();
    }

    public static void sortCountriesAndViewCapitals(Map<String, String> countriesAndCapitals) {
        List<String> capitals = countriesAndCapitals.keySet().stream()
                .sorted(String::compareTo)
                .map(countriesAndCapitals::get)
                .toList();
        System.out.println(capitals);
    }

    public static List<String> filterByCharAndSortByLength(List<String> words, char ch) {
        if (!Character.isLetter(ch)) {
            throw new IllegalArgumentException("The character is not a letter");
        }
        return words.stream()
                .filter(word -> word.toLowerCase().startsWith(Character.toString(ch).toLowerCase()))
                .sorted((wordOne, wordTwo) -> wordOne.length() - wordTwo.length())
                .toList();
    }

    public static List<List<String>> findStrangersWithCommonFriends(Map<String, List<String>> personAndHisFriends) {
        Set<Set<String>> strangers = personAndHisFriends.keySet().stream()
                .flatMap(personOne -> personAndHisFriends.keySet().stream()
                        .filter(personTwo -> !personOne.equals(personTwo))
                        .filter(personTwo -> !personAndHisFriends.get(personOne).contains(personTwo))
                        .map(personTwo -> Set.of(personOne, personTwo)))
                .collect(Collectors.toSet());

        return strangers.stream()
                .map(pair -> pair.stream().toList())
                .filter(pair -> isStrangersWithCommonFriends(pair, personAndHisFriends))
                .toList();
    }

    public static Map<String, Double> computeAvgSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> words, String alphabet) {
        return words.stream()
                .filter(word -> alphabet.chars().allMatch(c -> word.contains(String.valueOf((char) c))))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBin(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> searchPalindromeNums(int startNum, int endNum) {
        return IntStream.range(startNum, endNum + 1).boxed()
                .map(Objects::toString)
                .filter(word -> word.contentEquals(new StringBuilder(word).reverse()))
                .mapToInt(Integer::parseInt).boxed()
                .toList();
    }


    public static void main(String[] args) {
        System.out.println(createUniquePairsBySumValue(List.of(-1, 0, 1, 1, 1, 2, 3, 5, 6), 5));

        sortCountriesAndViewCapitals(Map.of(
                "Russia", "Moscow",
                "Great Britain", "London",
                "China", "Beijing")); //у китая рил так столица называется по-английски)

        System.out.println(filterByCharAndSortByLength(List.of("hello", "Hi!", "lol"), 'H'));

        String oleg = "Oleg";
        String petr = "Petr";
        String feodor = "Feodor";
        String victor = "Victor";
        String sam = "Sam";
        System.out.println(findStrangersWithCommonFriends(Map.of(
                oleg, List.of(petr, victor),
                petr, List.of(oleg, sam, feodor),
                feodor, List.of(petr, victor),
                sam, List.of(petr),
                victor, List.of(feodor, oleg))
        ));

        Employee employeeOne = new Employee("Oleg", 1000.0, "IT");
        Employee employeeTwo = new Employee("Petr", 1200.0, "IT");
        Employee employeeThree = new Employee("Feodor", 800.0, "Marketing");
        Employee employeeFour = new Employee("Sam", 1000.0, "Marketing");
        List<Employee> employees = List.of(employeeOne, employeeTwo, employeeThree, employeeFour);
        System.out.println(computeAvgSalaryByDepartment(employees));

        System.out.println(filterByAlphabetAndSortByLength(List.of("hi", "hiiii", "hhhhi", "lol123"), "hi"));

        System.out.println(convertToBin(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10000)));

        System.out.println(searchPalindromeNums(100, 202));
    }

    private static boolean isStrangersWithCommonFriends(List<String> strangersPair, Map<String, List<String>> personAndHisFriends) {
        String personOne = strangersPair.get(0);
        String personTwo = strangersPair.get(1);
        List<String> friendsOne = new ArrayList<>(personAndHisFriends.get(personOne));
        List<String> friendsTwo = personAndHisFriends.get(personTwo);
        friendsOne.retainAll(friendsTwo);
        return !friendsOne.isEmpty();
    }
}
