package faang.school.godbless.streams.trainingstreams2;

import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.Collectors;

@UtilityClass
public class StreamsUtil {

    public Map<Integer, Integer> uniquePairsStreams(List<Integer> numbers, int targetSum) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        numbers.stream()
                .flatMap(number -> numbers.stream()
                        .filter(pair -> !integerMap.containsKey(pair) && !integerMap.containsValue(pair)
                                && (pair == targetSum - number))
                        .map(i -> Map.entry(number, i)))
                .forEach(entry -> integerMap.put(entry.getKey(), entry.getValue()));
        return integerMap;
    }

    public void printCapitals(Map<String, String> countriesCapitals) {
        countriesCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getValue()));
    }

    public List<String> filterByCharAndSortByLength(char filterChar, List<String> strings) {
        return strings.stream()
                .filter(s -> s.toLowerCase().charAt(0) == filterChar)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public Map<String, String> findPotentialFriends(Map<String, List<String>> friends) {
        return friends.entrySet().stream()
                .flatMap(person -> friends.entrySet().stream()
                        .filter(friend ->
                                !friend.getValue().contains(person.getKey())
                                && !Collections.disjoint(person.getValue(), friend.getValue())
                                && !friend.getKey().equals(person.getKey())
                                && person.getKey().compareTo(friend.getKey()) < 0)
                        .map(friend -> Map.entry(friend.getKey(), person.getKey())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
