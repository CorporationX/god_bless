package faang.school.godbless.hobbyLovers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@ToString
@AllArgsConstructor
public class User {

    private final int id;
    private final String name;
    private final int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {

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
