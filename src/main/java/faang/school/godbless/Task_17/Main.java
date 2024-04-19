package faang.school.godbless.Task_17;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(uniquePairs(10, Arrays.asList(1, 9, 3, 6, 4, 5)));

        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("England", "London");

        System.out.println(capitals(countriesAndCapitals));
        System.out.println(stringsByParticularRules(Arrays.asList("First", "Second", "Fly", "Finally"), 'F'));

        Map<String, List<String>> peopleAndFriends = new HashMap<>();
        peopleAndFriends.put("John", Arrays.asList("Jessica", "Mike", "Tony"));
        peopleAndFriends.put("Kevin", Arrays.asList("Jessica", "Carla", "Boris"));
        peopleAndFriends.put("Melissa", Arrays.asList("Dorian", "Jason", "Pamella"));
        peopleAndFriends.put("Harry", Arrays.asList("Mike", "Oscar", "Tony"));

        peopleWithCommonFriends(peopleAndFriends);

        middleSalaryByDeparture(Arrays.asList(
                new Employee("John", 1000, "IT"),
                new Employee("Mike", 2000, "Service"),
                new Employee("Tony", 5000, "IT"),
                new Employee("Melissa", 5000, "Science"),
                new Employee("Oscar", 2000, "IT")
        ));
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'};

        sortStringsByAlphabet(Arrays.asList("apple", "banana", "123", "dog", "cat"), charArray);

        System.out.println(ListOfIntegersToListOfStrings(Arrays.asList(1, 2, 3, 4, 5)));

        allNumbersLikePalindrome(1, 50);
        allSubStringsInPalindrome("helolo");

    }

    static Map<Integer, Integer> uniquePairs(int sum, List<Integer> numbers) {
        Map<Integer, Integer> pairs = new HashMap<>();
        IntStream.range(0, numbers.size()).
                forEach(i -> IntStream.range(0, numbers.size()).
                        filter(j -> i != j && numbers.get(i) + numbers.get(j) == sum).
                        forEach(j -> {
                            if (!pairs.containsValue(numbers.get(i))) {
                                pairs.put(numbers.get(i), numbers.get(j));
                            }
                        }));
        return pairs;
    }

    static List<String> capitals(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).collect(Collectors.toList());
    }

    static List<String> stringsByParticularRules(List<String> strings, char letter) {
        return strings.stream().filter(s -> s.startsWith(String.valueOf(letter))).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    static void peopleWithCommonFriends(Map<String, List<String>> peopleAndFriends) {
        peopleAndFriends.entrySet().stream().
                filter(entryOne -> peopleAndFriends.entrySet().stream().
                        anyMatch(entryAnother -> {
                                    if (!entryOne.getKey().equals(entryAnother.getKey())) {
                                        return entryOne.getValue().stream().
                                                anyMatch(stringFromEntryOne -> entryAnother.getValue().stream().
                                                        anyMatch(stringFromEntryOne::equals));

                                    } else return false;
                                }
                        )).forEach(entry -> System.out.println(entry.getKey()));

    }

    static void middleSalaryByDeparture(List<Employee> employees) {
        Map<String, Double> middleSalaryByDeparture = new HashMap<>();
        employees.stream().collect(Collectors.groupingBy(Employee::getDeparture)).
                forEach((key, value) -> IntStream.range(0, value.size()).forEach(i -> {
                    if (i != 0) {
                        middleSalaryByDeparture.put(key, (middleSalaryByDeparture.get(key) + (value.get(i).getSalary()) / value.size()));
                    } else {
                        middleSalaryByDeparture.put(key, (value.get(i).getSalary()) / value.size());
                    }
                }));
        System.out.println(middleSalaryByDeparture);
    }

    static void sortStringsByAlphabet(List<String> strings, char[] alphabet) {
        List<String> stringsAfterActions = new ArrayList<>();
        strings.stream().sorted(Comparator.comparingInt(String::length)).
                forEach(string -> IntStream.range(0, alphabet.length).filter(i -> string.indexOf(alphabet[i]) != -1).forEach(i -> {
                    if (!stringsAfterActions.contains(string)) {
                        stringsAfterActions.add(string);
                    }
                }));
        System.out.println(stringsAfterActions);
    }

    static List<String> ListOfIntegersToListOfStrings(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    static void allNumbersLikePalindrome(int start, int end) {
        IntStream.range(start, end).filter(number -> Integer.toString(number).
                contentEquals(new StringBuilder(Integer.toString(number)).reverse())).forEach(System.out::println);
    }

    static void allSubStringsInPalindrome(String string) {
        string.chars().forEach(letter -> IntStream.range(0, string.length()).forEach(i -> String.valueOf(letter)));
    }
}
