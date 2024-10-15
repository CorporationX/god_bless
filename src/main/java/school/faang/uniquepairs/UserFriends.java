package school.faang.uniquepairs;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class UserFriends {
    public static Set<List<String>> findUniquePairs(Map<String, List<String>> groupedByFriends) {
        Set<List<String>> uniquePairs = new HashSet<>();
        groupedByFriends.keySet().stream()
                .forEach(person -> {
                    Set<String> friends = new HashSet<>(groupedByFriends.get(person));
                    Set<String> strangers = new HashSet<>(groupedByFriends.keySet());
                    strangers.removeAll(Set.of(friends, person));
                    strangers.forEach(stranger -> {
                        groupedByFriends.get(stranger).stream()
                                .filter(friends::contains)
                                .map(strangerFriend -> Stream.of(person, stranger)
                                .sorted()
                                .toList()).forEach(uniquePairs::add);
                    });
                });
        return uniquePairs;
    }
}
