package school.faang.bjs2_68353;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class User {
    private UUID id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> requestedActivities) {
        if (users == null || users.isEmpty() || requestedActivities == null || requestedActivities.isEmpty()) {
            return Collections.emptyMap();
        }

        return users.stream()
                .flatMap(user ->
                        Optional.ofNullable(user.getActivities())
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