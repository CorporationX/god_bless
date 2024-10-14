package school.faang;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Дмитрий (Сергей, Андрей), Никита (Артем, Евгений), Оля (Сергей, Андрей)


public class UserFriends {
    public static Set<List<String>> findUniquePairs(Map<String, List<String>> groupedByFriends) {
        Set<List<String>> uniquePairs = new HashSet<>();
        groupedByFriends.keySet().stream()
                .forEach(person -> {
                    Set<String> friends = new HashSet<>(groupedByFriends.get(person));
                    Set<String> strangers = new HashSet<>(groupedByFriends.keySet());
                    strangers.removeAll(Set.of(friends, person));
                    strangers.forEach(stranger -> {
                        groupedByFriends.get(stranger).forEach(strangerFriend -> {
                            if (friends.contains(strangerFriend)) {
                                uniquePairs.add(Stream.of(person, stranger)
                                        .sorted()
                                        .toList());
                            }
                        });
                    });
                });
        return uniquePairs;
    }
}
