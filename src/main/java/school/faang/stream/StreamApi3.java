package school.faang.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi3 {

    public record Pair<T>(T first, T second) {
    }

    public record Employee(String name, Double salary, String subdivision) {
    }


    public static List<Pair<String>> findCommonFriends(Map<String, List<String>> peopleWithFriends) {

        Map<String, List<String>> friendToPeople = new HashMap<>();
        peopleWithFriends.forEach((person, friends) ->
                friends.forEach(friend ->
                        friendToPeople.computeIfAbsent(friend, k -> new ArrayList<>()).add(person)
                )
        );

        return friendToPeople.values().stream()
                .filter(people -> people.size() > 1)
                .flatMap(StreamApi3::cartesianProduct)
                .filter(pair -> {
                    List<String> friendsOfPerson1 = peopleWithFriends.get(pair.first);
                    return friendsOfPerson1 == null || ! friendsOfPerson1.contains(pair.second);
                })
                .distinct()
                .collect(Collectors.toList());

    }

    private static <T> Stream<Pair<T>> cartesianProduct(List<T> inputList) {
        List<Pair<T>> pairs = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            for (int j = i + 1; j < inputList.size(); j++) {
                pairs.add(new Pair<>(inputList.get(i), inputList.get(j)));
            }
        }
        return pairs.stream();
    }

    public static Map<String, Double> findAverageSalaryBySubdivision(List<Employee> employees) {
        return employees
                .stream()
                .collect(Collectors.groupingBy(Employee::subdivision, Collectors.averagingDouble(Employee::salary)));
    }

    public static int[] findPalindromeInNumberInterval(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(num -> {
                    String originalString = String.valueOf(num);
                    String reverse = new StringBuilder(originalString).reverse().toString();
                    return originalString.equals(reverse);
                })
                .toArray();
    }

    // Как лучше сгенерить все подстроки?
    public static List<String> findSubstringPalindrome(String inputString) {
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = i + 1; j <= inputString.length(); j++) {
                substrings.add(inputString.substring(i, j));
            }
        }
        return substrings.stream()
                .filter(string -> string.equals(new StringBuilder(string).reverse().toString()))
                .toList();
    }

    public static int[] findPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(num -> {
                    Integer sumOfDivisors = findDivisors(num)
                            .stream()
                            .filter(divisor -> divisor != num)
                            .reduce((sum, divisor) -> sum + divisor)
                            .orElse(0);
                    return sumOfDivisors.equals(num);
                })
                .toArray();
    }

    private static Set<Integer> findDivisors(Integer num) {
        Set<Integer> divisors = new HashSet<>();
        for (int i = 1; i <= Math.ceil(Math.sqrt(num)); i++) {
            if (num % i == 0) {
                divisors.add(i);
                divisors.add(num / i);
            }
        }
        return divisors;
    }

    public static void main(String[] args) {
        Map<String, List<String>> personWithFriend = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")

        );

        List<Employee> employees = List.of(
                new Employee("Iya", 1000D, "IT"),
                new Employee("Bob", 500D, "IT"),
                new Employee("Alice", 300D, "IT"),
                new Employee("Iya", 1000D, "HR department")
        );

        System.out.println(findCommonFriends(personWithFriend));
        System.out.println(findAverageSalaryBySubdivision(employees));
        System.out.println(Arrays.toString(findPalindromeInNumberInterval(100, 200)));
        System.out.println(findSubstringPalindrome("abac"));
        System.out.println(Arrays.toString(findPerfectNumbers(1, 1000)));

    }
}
