package school.faang.collect_users;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private int birthDate;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        return users.stream().collect(
                Collectors.toMap(
                        user -> user,
                        user -> user.getActivities().stream()
                                .filter(activities::contains)
                                .findFirst().get()

                )
        );
    }
}
