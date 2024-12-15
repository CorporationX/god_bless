package school.faang.task_46851;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Map<String, Set<String>> friendsByPerson = Map.of(
                "Alice", Set.of("Bob", "Charlie"),
                "Bob", Set.of("Alice", "David"),
                "Charlie", Set.of("Alice", "David"),
                "David", Set.of("Bob", "Charlie")
        );
        System.out.printf("findPairsNonFriendsWithCommonFriends(friendsByPerson) = %s%n%n",
                findPairsNonFriendsWithCommonFriends(friendsByPerson));

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 250_000, "Sales"),
                new Employee("Bob", 250_000, "Marketing"),
                new Employee("Charlie", 230_000, "Sales"),
                new Employee("David", 240_000, "Marketing")
        );
        System.out.printf("getAverageSalaryByDepartment(employees) = %s%n%n", getAverageSalaryByDepartment(employees));

        System.out.printf("findPalindromesInRange(100, 200) = %s%n", findPalindromesInRange(100, 200));
        System.out.printf("findPalindromesInRange(0, 100) = %s%n%n", findPalindromesInRange(0, 100));

        System.out.printf("findPalindromicSubstrings(\"abac\") = %s%n", findPalindromicSubstrings("abac"));
        System.out.printf("findPalindromicSubstrings(\"ABBA\") = %s%n%n", findPalindromicSubstrings("ABBA"));

        System.out.printf("findPerfectNumbersInRange(1, 1000) = %s%n", findPerfectNumbersInRange(1, 1000));
        System.out.printf("findPerfectNumbersInRange(1, 10000) = %s%n%n", findPerfectNumbersInRange(1000, 10000));
    }

    private static Set<List<String>> findPairsNonFriendsWithCommonFriends(
            @NonNull Map<String, Set<String>> friendsByPerson) {
        Set<List<String>> pairs = new HashSet<>();

        friendsByPerson.forEach((person, friends) ->
                friendsByPerson.forEach((otherPerson, otherFriends) -> {
                    if (!person.equals(otherPerson)
                            && !friends.contains(otherPerson)
                            && !otherFriends.contains(person)) {
                        Set<String> commonFriends = new HashSet<>(friends);
                        commonFriends.retainAll(otherFriends);
                        if (!commonFriends.isEmpty()) {
                            List<String> pair = Arrays.asList(person, otherPerson);
                            Collections.sort(pair);
                            pairs.add(pair);
                        }
                    }
                })
        );

        return pairs;
    }

    private static Map<String, Double> getAverageSalaryByDepartment(@NonNull List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));
    }

    private static List<Integer> findPalindromesInRange(int startInclusive, int endInclusive) {
        return IntStream.rangeClosed(startInclusive, endInclusive)
                .mapToObj(String::valueOf)
                .filter(Main::isPalindrome)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    private static List<String> findPalindromicSubstrings(@NonNull String str) {
        return IntStream.range(0, str.length())
                .boxed()
                .flatMap(p1 -> IntStream.rangeClosed(p1 + 1, str.length())
                        .mapToObj(p2 -> str.substring(p1, p2)))
                .filter(Main::isPalindrome)
                .distinct()
                .toList();
    }

    private static boolean isPalindrome(@NonNull String str) {
        return str.contentEquals(new StringBuilder(str).reverse());
    }

    private static List<Integer> findPerfectNumbersInRange(int startInclusive, int endInclusive) {
        final Predicate<Integer> isPerfectNumber = num ->
                IntStream.rangeClosed(1, num / 2)
                        .filter(i -> num % i == 0)
                        .sum() == num;

        return IntStream.rangeClosed(startInclusive, endInclusive)
                .filter(isPerfectNumber::test)
                .boxed().toList();
    }

}
