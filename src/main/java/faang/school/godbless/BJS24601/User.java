package faang.school.godbless.BJS24601;

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
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        return users.stream()
                .filter(user -> user.getActivities().stream().anyMatch(hobbies::contains))
                .collect(Collectors.toMap(
                        user -> user,
                        user -> user.getActivities().stream().filter(hobbies::contains).findFirst().orElse("")
                ));
    }
}
