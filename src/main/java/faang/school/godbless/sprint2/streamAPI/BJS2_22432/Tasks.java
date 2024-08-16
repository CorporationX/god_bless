package faang.school.godbless.sprint2.streamAPI.BJS2_22432;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tasks {

    protected static void printPairsWithSum(List<Integer> numbers, int targetSum) {
        Set<List<Integer>> uniquePairs = numbers.stream().
                flatMap(n -> {
                    int complement = targetSum - n;
                    return IntStream.of(complement)
                            .filter(seen -> numbers.contains(seen) && seen != n)
                            .mapToObj(seen -> Arrays.asList(n, seen))
                            .filter(pair -> pair.get(0) < pair.get(1));
                })
                .collect(Collectors.toSet());

        System.out.println("Input list: " + numbers);
        System.out.println("Target sum: " + targetSum);

        System.out.print("Pairs: ");
        if (uniquePairs.isEmpty()) {
            System.out.println("No pairs found");
        } else {
            System.out.println(uniquePairs.stream()
                    .map(pair -> "[" + pair.get(0) + ", " + pair.get(1) + "]")
                    .collect(Collectors.joining(", ")));
        }
    }

    public static List<String> getCapitalsSortedByCountry(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStringsByLength(List<String> strings, char startingLetter) {
        return strings.stream()
                .filter(w -> w.startsWith(String.valueOf(startingLetter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<List<String>> findNonFriendPairsWithCommonFriends(Map<String, List<String>> friendships) {
          return friendships.keySet().stream()
                .flatMap(person -> friendships.keySet().stream()
                        .filter(person2 -> !person.equals(person2))
                        .filter(person2 -> !friendships.get(person).contains(person2))
                        .filter(person2 -> friendships.get(person).stream().anyMatch(friendships.get(person2)::contains))
                        .map(person2 -> Arrays.asList(person, person2)))
                .distinct()
                .map(pair -> pair.stream().sorted().toList())
                .distinct()
                .toList();
    }


}
