package faang.school.godbless.javacore.collectusers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        return users.stream()
                .filter(user -> user.getActivities().stream().anyMatch(activities::contains))
                .collect(Collectors.toMap(
                        user -> user,
                        user -> user.getActivities().stream()
                                .sorted()
                                .filter(activities::contains)
                                .findFirst()
                                .get()
                ));
    }

}
