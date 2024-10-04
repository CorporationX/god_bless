package school.faang.hobbyUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbySet) {
        Map<User, String> result = new HashMap<>();
        users.forEach(user -> user.activities.stream()
                .filter(hobbySet::contains)
                .findFirst()
                .ifPresent(activities -> result.computeIfAbsent(user, v -> activities)));
        return result;
    }
}
