package school.faang.bjs2_70914;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperations {
    public static Set<Pair<String>> findAllNonFriendsWithCommonFriends(Map<String, List<String>> friendsMap) {
        List<String> people = new ArrayList<>(friendsMap.keySet());

        return IntStream.range(0, people.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, people.size())
                        .mapToObj(j -> {
                            String personA = people.get(i);
                            String personB = people.get(j);
                            List<String> friendsA = friendsMap.getOrDefault(personA, List.of());
                            List<String> friendsB = friendsMap.getOrDefault(personB, List.of());
                            boolean areDirectFriends = friendsA.contains(personB) || friendsB.contains(personA);
                            boolean haveMutualFriends = friendsA.stream().anyMatch(friendsB::contains);
                            if (!areDirectFriends && haveMutualFriends) {
                                return Optional.of(new Pair<>(personA, personB));
                            } else {
                                return Optional.<Pair<String>>empty();
                            }
                        }))
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> groupByDepartmentAndFindAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
    }

    public static List<Integer> findPalindromes(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .boxed()
                .map(Object::toString)
                .filter(CollectionOperations::isPalindrome)
                .map(Integer::parseInt)
                .toList();
    }

    public static List<String> findAllPalindromeSubstrings(String input) {
        int length = input.length();
        return IntStream.range(0, length)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, length)
                        .mapToObj(j -> input.substring(i, j)))
                .filter(CollectionOperations::isPalindrome)
                .distinct()
                .toList();
    }

    public static List<Integer> findPerfectNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .filter(CollectionOperations::isPerfect)
                .boxed()
                .toList();
    }

    private static boolean isPerfect(int num) {
        int sumOfDividers = IntStream.range(1, num)
                .filter(value -> num % value == 0)
                .sum();
        return sumOfDividers == num;
    }

    private static boolean isPalindrome(String string) {
        return string.contentEquals(new StringBuilder(string).reverse());
    }
}