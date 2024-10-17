package school.faang.streamapithree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;


public class CommonFriendsFinder {

    public static List<Pair> findPairsWithCommonFriends(Map<String, List<String>> friendsMap) {
        List<Pair> result = new ArrayList<>();
        Set<Pair> checkedPairs = new HashSet<>();

        for (Map.Entry<String, List<String>> entry : friendsMap.entrySet()) {
            String person = entry.getKey();
            List<String> friends = entry.getValue();

            for (String friend : friends) {
                for (Map.Entry<String, List<String>> otherEntry : friendsMap.entrySet()) {
                    String otherPerson = otherEntry.getKey();
                    List<String> otherFriends = otherEntry.getValue();

                    if (!person.equals(otherPerson) && !friends.contains(otherPerson)) {
                        Set<String> commonFriends = new HashSet<>(friends);
                        commonFriends.retainAll(otherFriends);

                        if (!commonFriends.isEmpty()) {
                            Pair newPair = new Pair(person, otherPerson);
                            Pair reversePair = new Pair(otherPerson, person);

                            if (!checkedPairs.contains(reversePair)) {
                                result.add(newPair);
                                checkedPairs.add(newPair);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Pair {
        private String person1;
        private String person2;
    }
}
