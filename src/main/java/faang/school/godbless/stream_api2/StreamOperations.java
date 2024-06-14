package faang.school.godbless.stream_api2;

import lombok.NonNull;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamOperations {
    public static List<List<Integer>> pairConstructor(@NonNull List<Integer> integers, int sum) {
        return integers.stream()
                .filter(integer -> integers.contains(sum - integer))
                .filter(integer -> integers.indexOf(integer) != integers.lastIndexOf(sum - integer))
                .map(integer -> List.of(Math.min(integer, sum - integer), Math.max(integer, sum - integer)))
                .distinct().toList();
    }

    public static void showCountriesAndCapitals(@NonNull Map<String, String> countryCapital) {
        countryCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
    }

    public static List<String> filterBeginsWithAndSortByLength(@NonNull List<String> strings,
                                                               char letter) {
        return strings.stream()
                .filter(string -> string.toLowerCase().startsWith(String.valueOf(letter).toLowerCase()))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Set<List<String>> findUnknownFriends(@NonNull Map<String, List<String>> friends) {
        Set<List<String>> farFriends = new HashSet<>();

        // Using BFS algorithm
        friends.keySet().forEach(primaryFriendName -> {
            Map<String, Boolean> isProcessed = new HashMap<>();
            Queue<FriendWalkingNode> queue = new LinkedList<>();
            queue.add(new FriendWalkingNode(primaryFriendName, primaryFriendName, 0));

            while (!queue.isEmpty()) {
                FriendWalkingNode nodeToProcess = queue.poll();
                String friendToProcessName = nodeToProcess.getName();
                int depth = nodeToProcess.getDepth();
                isProcessed.put(friendToProcessName, true);

                friends.get(friendToProcessName).stream()
                        .filter(friendName -> !isProcessed.getOrDefault(friendName, false))
                        .peek(friendName -> queue.add(new FriendWalkingNode(friendName, primaryFriendName, depth + 1)))
                        .filter(friendName -> depth >= 1)
                        .forEach(friendName -> farFriends.add(Stream.of(friendName, primaryFriendName).sorted().toList()));
            }
        });

        return farFriends;
    }

    public static Map<String, Double> getAverageSalaryByDepartment(@NonNull List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));
    }

    public static List<String> filterByAlphabetAndSortByLength(@NonNull List<String> strings,
                                                               @NonNull String alphabet) {
        return strings.stream()
                .filter(string -> IntStream.range(0, string.length())
                        .allMatch(index -> alphabet.indexOf(string.charAt(index)) != -1))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> binaryConverter(@NonNull List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findPalindromeIntegersInRange(int lowerBound, int upperBound) {
        return IntStream.rangeClosed(lowerBound, upperBound)
                .filter(integer -> String.valueOf(integer).contentEquals(new StringBuilder(String.valueOf(integer)).reverse()))
                .boxed()
                .toList();
    }

    public static Set<String> findAllPalindromesInString(@NonNull String originalString) {
        return IntStream.range(0, originalString.length())
                .boxed()
                .flatMap(integer -> IntStream.range(integer + 1, originalString.length())
                        .mapToObj(end -> originalString.substring(integer, end + 1)))
                .filter(string -> string.contentEquals(new StringBuilder(string).reverse()))
                .collect(Collectors.toSet());
    }

    public static List<Integer> findAllPerfectNumbersInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(integer -> integer > 1)
                .filter(integer -> IntStream.range(2, integer)
                        .filter(divisor -> integer % divisor == 0)
                        .reduce(1, Integer::sum) == integer)
                .boxed()
                .toList();
    }
}
