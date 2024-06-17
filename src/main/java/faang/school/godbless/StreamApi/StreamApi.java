package faang.school.godbless.StreamApi;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApi {

    public static List<List<Integer>> findUniquePairsSum(List<Integer> numbers, int targetSum){
        Set<Integer> lookedNumbers = new HashSet<>();
        return numbers.stream()
                .filter(num -> {
                    int secondPairNum = targetSum - num;
                    if (lookedNumbers.contains(secondPairNum)) {
                        return true;
                    }
                    lookedNumbers.add(secondPairNum);
                    return false;
        })
                .map(num -> Arrays.asList(num, targetSum - num))
                .collect(Collectors.toList());
    }

    public static List<String> sortCapitals(Map<String, String> countriesAndCapitals){
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());  // мы тут собираем элементы потока в список при помощи метода
    }

    public static List<String> filterAndSortStrings(List<String> strings, char startChar){
        return strings.stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == startChar)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<List<String>> findCommonFriends(Map<String, List<String>> people){
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry1 : people.entrySet()) {
            String person1 = entry1.getKey();
            List<String> friends1 = entry1.getValue();

            for (Map.Entry<String, List<String>> entry2 : people.entrySet()) {
                String person2 = entry2.getKey();
                List<String> friends2 = entry2.getValue();

                if (!person1.equals(person2) && !friends1.contains(friends2)) {
                    List<String> commonFriends = new ArrayList<>(friends1);
                    commonFriends.retainAll(friends2);

                    if (!commonFriends.isEmpty()) {
                        result.add(Arrays.asList(person1, person2));
                    }
                }
            }
        }
    return result;
    }
}







