package bjs2_2124;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    private int id;
    private String name;
    private Set<String> activities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(activities, user.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, activities);
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> userStringMap = new HashMap<>();

        users.forEach(user ->
                user.activities.forEach(userActivity -> {
                    if (activities.contains(userActivity)) {
                        userStringMap.put(user, userActivity);
                    }
                }));
        return userStringMap;
    }
}
