package faang.school.godbless.streamApiSecond;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiExamples {
    public static List<List<Integer>> uniquePairsWithGivenSum(List<Integer> numbers, int sum) {
        Set<Integer> setForAvoidingDuplicates = new HashSet<>();
        return numbers.stream()
                .flatMap(n -> {
                    int check = sum - n;
                    if (setForAvoidingDuplicates.contains(check)) {
                        return Stream.of(List.of(n, check));
                    } else {
                        setForAvoidingDuplicates.add(n);
                        return Stream.empty();
                    }
                })
                .distinct()
                .toList();
    }

    public static List<String> getCapitalsOfSortedCountries(Map<String, String> countries) {
        return countries.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> sortByLengthStringsStartingWith(List<String> strings, char ch) {
        return strings.stream()
                .filter(string -> string.startsWith(ch + ""))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static boolean haveCommonFriends(List<String> first, List<String> second) {
        return first.stream().anyMatch(second::contains);
    }

    public static List<List<String>> possibleFriends(Map<String, List<String>> people) {
        return people.keySet()
                .stream()
                .flatMap(person -> people.keySet().stream()
                    .filter(friend -> !person.equals(friend) && !people.get(person).contains(friend))
                    .filter(friend -> haveCommonFriends(people.get(friend), people.get(person)))
                    .map(friend -> List.of(person, friend)))
                .toList();
    }

    public static Map<String, Double> getAverageSalaryForDepartments(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> stringsFromGivenAlphabetSortedByLength(List<String> strings, char[] alphabetArray) {
        Set<Character> alphabet = new HashSet<>();
        for (char c : alphabetArray) {
            alphabet.add(c);
        }

        return strings
                .stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinaryStrings(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    private static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static List<Integer> findPalindromesInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(StreamApiExamples::isPalindrome)
                .boxed()
                .toList();
    }

    private static boolean isPalindrome(String substring) {
        String reversed = new StringBuilder(substring).reverse().toString();
        return substring.equals(reversed);
    }

    public static List<String> findPalindromicSubstrings(String str) {
        return IntStream.range(0, str.length())
                .boxed()
                .flatMap(start -> IntStream.range(start + 1, str.length() + 1)
                        .mapToObj(end -> str.substring(start, end)))
                .filter(StreamApiExamples::isPalindrome)
                .distinct()
                .toList();
    }

    private static boolean isPerfect(int number) {
        int sumOfDivisors = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sumOfDivisors += i;
            }
        }
        return sumOfDivisors == number;
    }

    public static List<Integer> findPerfectNumbersInRange(int start, int end) {
        return IntStream
                .rangeClosed(start, end)
                .filter(StreamApiExamples::isPerfect)
                .boxed()
                .toList();
    }

    public static void main(String[] args) {
        //1
        List<Integer> numbers = List.of(1, 9, 3, 6, 4, 5, 9);
        System.out.println(uniquePairsWithGivenSum(numbers, 10) + "\n");

        //2
        HashMap<String, String> countries = new HashMap<>();
        countries.put("United States", "Washington");
        countries.put("Germany", "Berlin");
        countries.put("France", "Paris");
        countries.put("Russia", "Moscow");
        System.out.println(getCapitalsOfSortedCountries(countries) + "\n");

        //3
        List<String> strings = List.of("summer", "sand", "programming","string", "stream", "java");
        System.out.println(sortByLengthStringsStartingWith(strings, 's') + "\n");

        //4
        Map<String, List<String>> friendships = new HashMap<>();
        friendships.put("Alice", List.of("Bob", "Charlie"));
        friendships.put("Bob", List.of("Alice", "David"));
        friendships.put("Charlie", List.of("Alice", "David", "Eve"));
        friendships.put("David", List.of("Bob", "Charlie"));
        friendships.put("Eve", List.of("Charlie"));
        System.out.println(possibleFriends(friendships) + "\n");

        //5
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000, "HR"),
                new Employee("Bob", 60000, "IT"),
                new Employee("Charlie", 55000, "IT"),
                new Employee("David", 70000, "HR"),
                new Employee("Eve", 80000, "Finance")
        );
        getAverageSalaryForDepartments(employees).forEach((department, avgSalary) ->
                System.out.println("Department: " + department + ", Average salary: " + avgSalary));
        System.out.println();

        //6
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        List<String> stringList = List.of("dog", "apple", "123", "cat", "banana");
        System.out.println(stringsFromGivenAlphabetSortedByLength(stringList, alphabet) + "\n");

        //7
        System.out.println(toBinaryStrings(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) + "\n");

        //8
        System.out.println(findPalindromesInRange(1, 100) + "\n");

        //9
        String string = "nnnababak";
        System.out.println(findPalindromicSubstrings(string) + "\n");

        //10
        System.out.println(findPerfectNumbersInRange(1, 10000));
    }
}
