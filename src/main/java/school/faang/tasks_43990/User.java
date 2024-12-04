package school.faang.tasks_43990;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        return users.stream()
                .filter(user -> user.getActivities().stream().anyMatch(hobbies::contains))
                .collect(Collectors.toMap(
                        user -> user,
                        user -> user.getActivities().stream()
                                .filter(hobbies::contains)
                                .findFirst()
                                .orElse("Not founds hobby"))
                );
    }
}