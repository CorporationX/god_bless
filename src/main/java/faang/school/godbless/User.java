package faang.school.godbless;

import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class User {

    private final int id;
    private String name;
    private int age;
    private HashSet<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, HashSet<String> activities) {

        return users.stream()
                .filter(u -> {
                    u.getActivities().retainAll(activities);
                    return !u.getActivities().isEmpty();
                }).collect(Collectors.toMap(u -> u, u -> u.getActivities().iterator().next()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
