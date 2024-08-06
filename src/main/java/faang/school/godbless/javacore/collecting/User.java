package faang.school.godbless.javacore.collecting;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activitiesToFind) {
        return users.stream()
                .filter(user -> user.activities.stream().anyMatch(activitiesToFind::contains))
                .collect(Collectors.toMap(
                        user -> user,
                        user -> user.activities.stream().filter(activitiesToFind::contains).findFirst().get()));
    }
}
