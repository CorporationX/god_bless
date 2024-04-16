package faang.school.godbless.stream_two;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums = List.of(2, 4, 3, 3);
        System.out.println("unique pairs of numbers: " + uniquePairs(nums, 6));

        Map<String, String> countryWithCapitals = new HashMap<>() {
            {
                put("Canada", "Ottawa");
                put("China", "Beijing");
                put("Egypt", "Cairo");
                put("Syria", "Damascus");
                put("Vietnam", "Hanoi");
                put("Austria", "Vienna");
            }
        };
        System.out.println("Name of capital: " + sortedCapitals(countryWithCapitals));

        List<String> strings = List.of("ab", "bcd", "abcd", "abc");
        System.out.println("Filtered strings and sorted by ack: " + filteredByChar(strings, 'a'));

        Map<String, List<String>> friends = new HashMap<>() {
            {
                put("Alex", List.of("Tom", "Bob"));
                put("Jon", List.of("Miranda", "Tom"));
                put("Ann", List.of("Bob", "Miranda"));
                put("Tom", List.of("Alex", "Bob"));
                put("Bob", List.of("Tom", "Alex"));
            }
        };
        System.out.println("Friends " + findPairsWithMutuaFriends(friends));

        List<Employee> employes = List.of(
                new Employee("Nick", 100, "A"),
                new Employee("Ann", 70, "B"),
                new Employee("John", 110, "B"),
                new Employee("Alice", 90, "B"),
                new Employee("Petr", 120, "A")
        );
        System.out.println("Average salary by departments: " + averageSalaryByDepartments(employes));

        String engAlphabet = "[^a-z]";
        int alphabetLength = 26;
        List<String> multyLeng = List.of("Phrase in English", "Фраза на Русском", "English");
        System.out.println("Filtered by English alphabet: " +
                filteredByDifferentAlphabet(multyLeng, engAlphabet, alphabetLength));

        List<Integer> numsToTranslate = List.of(6546, 56576, 13345900, 9876666);
        System.out.println("Transformed integets to hex: " + intToHexString(numsToTranslate));

        int rangeStart = 10000;
        int rangeEnd = 1000000;
        System.out.println("Found palindrome in range (" + rangeStart + ", " + rangeEnd + ") of numbers: "
                + findNumsPalindrome(rangeStart, rangeEnd));
    }

    public static Map<Integer, Integer> uniquePairs(List<Integer> nums, int number) {
        Map<Integer, Integer> pairs = new HashMap<>();

        IntStream.range(0, nums.size())
                .forEach(i -> IntStream.range(i + 1, nums.size())
                        .filter(j -> nums.get(i) + nums.get(j) == number)
                        .forEach(j -> pairs.put(nums.get(j), nums.get(i)))
                );
        return pairs;
    }

    public static List<String> sortedCapitals(Map<String, String> data) {
        return data.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filteredByChar(List<String> strings, char template) {
        return strings.stream()
                .filter(s -> s.charAt(0) == template)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Map<String, String> findPairsWithMutuaFriends(Map<String, List<String>> friends) {
        Map<String, String> pairs = new HashMap<>();
        friends.forEach((key, value) -> friends.entrySet().stream()
                .filter(entry -> !key.equals(entry.getKey()) && !value.contains(entry.getKey()))
                .forEach(entry -> entry.getValue().stream()
                        .filter(value::contains)
                        .forEach(f -> pairs.put(key, entry.getKey())))
        );
        return pairs;
    }

    public static Map<String, Double> averageSalaryByDepartments(List<Employee> empoloyes) {
        return empoloyes.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)
                ));
    }

    public static List<String> filteredByDifferentAlphabet(
            List<String> strings, String alphabet, int alphabetLength) {
        return strings.stream()
                .filter(
                        s -> s.toLowerCase()
                                .replaceAll(alphabet, "")
                                .replaceAll("(.)(?=.*\\1)", "")
                                .length() > 0
                )
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> intToHexString(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findNumsPalindrome(int rangeStart, int rangeEnd) {
        return IntStream
                .range(rangeStart, rangeEnd)
                .filter(n -> isPalindrome(n))
                .boxed()
                .toList();
    }

    private static boolean isPalindrome(int number) {
        int reversed = 0;
        int tmp = number;
        while (tmp != 0) {
            int dig = tmp % 10;
            reversed = reversed * 10 + dig;
            tmp = tmp / 10;
        }
        return number == reversed;
    }
}

