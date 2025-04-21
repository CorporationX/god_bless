package school.faang.bjs2_68353;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record User(UUID id, String name, int age, Set<String> activities) {
    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> requestedActivities) {
        if (users == null || users.isEmpty() || requestedActivities == null || requestedActivities.isEmpty()) {
            return Collections.emptyMap();
        }

        return users.stream()
                .flatMap(user ->
                        Optional.ofNullable(user.activities())
                                .orElse(Collections.emptySet())
                                .stream()
                                .filter(requestedActivities::contains)
                                .findFirst()
                                .stream()
                                .map(activity -> Map.entry(user, activity))
                )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}