package school.faang.streamapithree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class CommonFriendsFinder {

    public static List<Pair> findPairsWithCommonFriends(Map<String, List<String>> friendsMap) {
        Set<Pair> checkedPairs = new HashSet<>();

        return friendsMap.entrySet().stream()
                .flatMap(entry -> {
                    String person = entry.getKey();
                    List<String> friends = entry.getValue();

                    return friendsMap.entrySet().stream()
                            .filter(otherEntry -> {
                                String otherPerson = otherEntry.getKey();
                                List<String> otherFriends = otherEntry.getValue();

                                return !person.equals(otherPerson) && !friends.contains(otherPerson);
                            })
                            .map(otherEntry -> {
                                String otherPerson = otherEntry.getKey();
                                List<String> otherFriends = otherEntry.getValue();

                                Set<String> commonFriends = new HashSet<>(friends);
                                commonFriends.retainAll(otherFriends);

                                if (!commonFriends.isEmpty()) {
                                    Pair newPair = new Pair(person, otherPerson);
                                    Pair reversePair = new Pair(otherPerson, person);

                                    if (!checkedPairs.contains(reversePair)) {
                                        checkedPairs.add(newPair);
                                        return newPair;
                                    }
                                }
                                return null;
                            })
                            .filter(Objects::nonNull);
                })
                .distinct()
                .collect(Collectors.toList());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Pair {
        private String person1;
        private String person2;
    }
}
