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
        peopleAndFriends.put("Harry", Arrays.asList("Jessica", "Oscar", "Tony"));
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

        System.out.println(ListOfIntegersToListOfStrings(Arrays.asList(0, 0, -3, 4, 5)));

        allNumbersLikePalindrome(1, 50);

        allPalindromeSubstrings("helolo");

        allPerfectNumbers(1, 6);

    }

    static Map<Integer, Integer> uniquePairs(int sum, List<Integer> numbers) {
        if (numbers != null) {
            Map<Integer, Integer> pairs = new HashMap<>();
            IntStream.range(0, numbers.size()).
                    forEach(i -> IntStream.range(0, numbers.size()).filter(Objects::nonNull).filter(j -> i != j && numbers.get(i) + numbers.get(j) == sum).forEach(j -> {
                        if (!pairs.containsValue(numbers.get(i))) {
                            pairs.put(numbers.get(i), numbers.get(j));
                        }
                    }));
            return pairs;
        } else throw new IllegalArgumentException("Input is null");
    }

    static List<String> capitals(Map<String, String> countriesAndCapitals) {
        if (countriesAndCapitals != null) {
            return countriesAndCapitals.entrySet().stream().filter(entry -> entry.getKey() != null && entry.getValue() != null).
                    sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).collect(Collectors.toList());
        } else throw new IllegalArgumentException("Input is null");
    }

    static List<String> stringsByParticularRules(List<String> strings, char letter) {
        if (strings != null) {
            return strings.stream().filter(s -> s.startsWith(String.valueOf(letter))).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        } else throw new IllegalArgumentException("Input is null");
    }

    static void peopleWithCommonFriends(Map<String, List<String>> peopleAndFriends) {
        if (peopleAndFriends != null) {
            peopleAndFriends.entrySet().stream().
                    filter(entryOne -> peopleAndFriends.entrySet().stream().
                            filter(entryAnother -> entryOne.getKey() != null && entryAnother.getKey() != null && entryOne.getValue() != null && entryAnother.getValue() != null).
                            anyMatch(entryAnother -> {
                                        if (!entryOne.getKey().equals(entryAnother.getKey())) {
                                            return entryOne.getValue().stream().filter(Objects::nonNull).
                                                    anyMatch(stringFromEntryOne ->
                                                            entryAnother.getValue().stream().filter(Objects::nonNull).anyMatch(stringFromEntryOne::equals));
                                        } else return false;
                                    }
                            )).forEach(entry -> System.out.println(entry.getKey()));
        } else throw new IllegalArgumentException("Input is null");
    }

    static void middleSalaryByDeparture(List<Employee> employees) {
        if (employees != null) {
            Map<String, Double> middleSalaryByDeparture = new HashMap<>();
            employees.stream().filter(employee -> employee.getDeparture() != null && employee.getSalary() >= 0).collect(Collectors.groupingBy(Employee::getDeparture)).
                    forEach((key, value) -> IntStream.range(0, value.size()).forEach(i -> {
                                if (i != 0) {
                                    middleSalaryByDeparture.put(key, (middleSalaryByDeparture.get(key) + (value.get(i).getSalary()) / value.size()));
                                } else {
                                    middleSalaryByDeparture.put(key, (value.get(i).getSalary()) / value.size());
                                }
                            }
                    ));
            System.out.println(middleSalaryByDeparture);
        } else throw new IllegalArgumentException("Input is null");
    }

    static void sortStringsByAlphabet(List<String> strings, char[] alphabet) {
        if (strings != null) {
            List<String> stringsAfterActions = new ArrayList<>();
            strings.stream().filter(Objects::nonNull).sorted(Comparator.comparingInt(String::length)).
                    forEach(string -> IntStream.range(0, alphabet.length).filter(i -> string.indexOf(alphabet[i]) != -1).forEach(i -> {
                        if (!stringsAfterActions.contains(string)) {
                            stringsAfterActions.add(string);
                        }
                    }));
            System.out.println(stringsAfterActions);
        } else throw new IllegalArgumentException("Input is null");
    }

    static List<String> ListOfIntegersToListOfStrings(List<Integer> numbers) {
        if (numbers != null) {
            return numbers.stream().map(Integer::toBinaryString).toList();
        } else throw new IllegalArgumentException("Input is null");
    }

    static void allNumbersLikePalindrome(int start, int end) {
        if (start > 0 && end > 0) {
            IntStream.range(start, end).filter(number -> Integer.toString(number).
                    contentEquals(new StringBuilder(Integer.toString(number)).reverse())).forEach(System.out::println);
        } else throw new IllegalArgumentException("Value of input numbers < 0");
    }

    static void allPalindromeSubstrings(String string) {
        if (string != null) {
            List<String> subStrings = new ArrayList<>();
            IntStream.range(0, string.length()).forEach(i ->
                    IntStream.range(i + 1, string.length()).filter(j -> string.substring(i, j + 1).contentEquals(new StringBuilder(string.substring(i, j + 1)).reverse())).
                            forEach(j -> subStrings.add(string.substring(i, j + 1))));
            System.out.println(subStrings);
        } else throw new IllegalArgumentException("Input is null");
    }

    static void allPerfectNumbers(int start, int end) {
        if (start > 0 && end > 0) {
            IntStream.range(start == 1 ? start + 1 : start, end + 1).filter(number -> number == (IntStream.range(1, number).filter(i -> number % i == 0).reduce(Integer::sum)).getAsInt()).
                    forEach(System.out::println);
        } else throw new IllegalArgumentException("Value of input numbers < 0");
    }
}
