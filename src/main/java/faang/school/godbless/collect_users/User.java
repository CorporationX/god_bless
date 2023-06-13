package faang.school.godbless.collect_users;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@EqualsAndHashCode
@AllArgsConstructor
public class User {
    @EqualsAndHashCode.Include
    private int id;

    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(@NonNull List<User> users, @NonNull Set<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users.stream().filter(Objects::nonNull).collect(Collectors.toSet())) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    result.put(user, activity);
                }
            }
        }
        return result;
    }

    private Set<String> getActivities() {
        return activities;
    }
}
