package faang.school.godbless.StreameAPI_2;

import java.util.*;
import java.util.stream.Collectors;

public class UnfriendlyPairs {
    public static List<List<String>> findUnfriendlyPairsUsingStream(HashMap<String, List<String>> friendsGraph) {
        return friendsGraph.entrySet().stream()
                .flatMap(entry -> friendsGraph.entrySet().stream()
                .filter(other -> !entry.getKey().equals(other.getKey()) && !entry.getValue().contains(other.getKey()))
                .map(other -> findCommonFriendsAndPair(entry, other)))
                .filter(pair -> !pair.isEmpty())
                .collect(Collectors.toList());
    }

    private static List<String> findCommonFriendsAndPair(Map.Entry<String, List<String>> entry1, Map.Entry<String, List<String>> entry2) {
        Set<String> commonFriends = new HashSet<>(entry1.getValue());
        commonFriends.retainAll(entry2.getValue());
        if (!commonFriends.isEmpty()) {
            return List.of(entry1.getKey(), entry2.getKey());
        }
        return Collections.emptyList();
    }
}

