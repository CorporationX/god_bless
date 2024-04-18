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
        IntStream.range(0, peopleAndFriends.size()).forEach(i -> peopleAndFriends.entrySet().stream().
    }
}
