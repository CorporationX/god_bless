package streamapi.two;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Friends {

    private static boolean hasMutualFriends(Map<String, List<String>> friendMap,
                                            String person1, String person2) {

        return friendMap.get(person1).stream()
                .anyMatch(friendMap.get(person2)::contains);
    }

    public static List<List<String>> findNonFriendsWithMutualFriends(Map<String, List<String>> friendMap) {

        return friendMap.keySet().stream()
                .flatMap(person -> friendMap.keySet().stream()
                        .filter(person2 -> person.compareTo(person2) < 0)
                        .filter(person2 -> !friendMap.get(person).contains(person2))
                        .filter(person2 -> hasMutualFriends(friendMap, person, person2))
                        .map(person2 -> Arrays.asList(person, person2)))
                .distinct()
                .collect(Collectors.toList());
    }
}
