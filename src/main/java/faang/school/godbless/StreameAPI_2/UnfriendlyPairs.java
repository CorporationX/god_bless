package faang.school.godbless.StreameAPI_2;

import java.util.*;
import java.util.stream.Collectors;

public class UnfriendlyPairs {
    public static Set<List<String>> findUnfriendlyPairs(HashMap<String, List<String>> friendsGraph) {
        Set<List<String>> answer = new HashSet<>();
        friendsGraph.forEach((key, value) -> friendsGraph.entrySet().stream()
                .filter(entry -> !key.equals(entry.getKey()))
                .filter(entry -> !value.contains(entry.getKey()))
                .filter(entry -> !entry.getValue().contains(key))
                .filter(entry -> !Collections.disjoint(value, entry.getValue()))
                .forEach(entry -> {
                    if (key.compareTo(entry.getKey()) > 0) {
                        answer.add(List.of(key, entry.getKey()));
                    } else {
                        answer.add(List.of(entry.getKey(), key));
                    }
                })
        );
        return answer;
    }
}

