package school.faang.sprint1.bjs_43985;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class User {
    private final int id;
    private final String name;
    private final int age;
    @Getter
    private final Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age
                + ", activities=" + activities + '}';
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> activeUsers = users.stream()
                .flatMap(user -> user.getActivities().stream()
                        .filter(hobbies::contains)
                        .map(hobby -> Map.entry(user, hobby)))
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                        (existing, replacement) -> existing));
        return activeUsers;
    }
}
