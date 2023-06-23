package faang.school.godbless.StreamApi2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApi {

    public static Map<Integer, Integer> getPairsOfSum(int[] integers, int number) {

        Map<Integer, Integer> pairs = new HashMap();
        IntStream.range(0, integers.length)
                .forEach(i -> IntStream.range(0, integers.length)
                        .filter(j -> i != j && integers[i] + integers[j] == number)
                        .forEach(j -> pairs.put(integers[i], integers[j]))
                );
        return pairs;
    }

    public static List<String> getCapitals(Map<String, String> countries) {
        validateMap(countries);
        return countries
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> getStringsFilteredByCharAndSorted(List<String> strings, char letter) {
        String letterStr = String.valueOf(letter);
        validateList(strings);
        return strings.stream()
                .filter(string -> string.startsWith(letterStr))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static Map<String, String> getFriendsOfFriends(Map<String, List<String>> friends) {
        validateMap(friends);
        Map<String, String> friendsOfFriends = new HashMap<>();

        friends.forEach((human, hisFriends) -> hisFriends
                .forEach(friend -> friends.forEach((key, value) -> {
                    if (!key.equals(human) && value.contains(friend)
                            && !hisFriends.contains(key) && !value.contains(human)) {
                        if (friendsOfFriends.containsKey(key)) {
                            if (!friendsOfFriends.get(key).contains(human)) {
                                friendsOfFriends.put(human, key);
                            }
                        } else {
                            friendsOfFriends.put(human, key);
                        }
                    }
                })));
        return friendsOfFriends;
    }

    public static Map<String, Double> getAverageSalary(List<Employee> employees) {
        validateList(employees);
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream().mapToDouble(Employee::salary).average().orElseThrow()));
    }

    public static List<String> alphabetContains(List<String> list, String alphabet) {
        validateList(list);
        return list.stream()
                .filter(s -> Set.of(alphabet.split(""))
                        .containsAll(List.of(s.replaceAll(" ", "").split(""))))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> integers) {
        validateList(integers);
        return integers.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }

    public static List<Integer> getPalindromicNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(i -> String.valueOf(i).equals(new StringBuilder(String.valueOf(i)).reverse().toString()))
                .boxed()
                .toList();
    }

    private static <T> void validateList(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
    }

    private static <K, V> void validateMap(Map<K, V> map) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("Map is empty");
        }
    }
}
