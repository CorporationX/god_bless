package school.faang.userhobbies;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Builder
public class User {
    private final int id;
    private final String name;
    private final int age;
    @Getter
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = (activities != null) ? new HashSet<>(activities) : new HashSet<>();
    }

    public static List<User> findHobbyLovers(List<User> users, Set<String> hobbies) {
        List<User> result = new ArrayList<>();

        for (User user : users) {

            for (String hobby : user.getActivities()) {
                if (hobbies.contains(hobby)) {
                    result.add(user);
                    break;
                }
            }
        }
        return result;
    }
}
