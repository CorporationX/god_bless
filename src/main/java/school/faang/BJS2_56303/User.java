package school.faang.BJS2_56303;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;


@Getter
@EqualsAndHashCode
public class User {
    private int id;
    private String name;
    private int age;

    private Set<String> hobbies;

    public User(int id, String name, int age, Set<String> hobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobbies = (hobbies != null)
                ? Set.copyOf(hobbies)
                : Collections.emptySet();
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        if (users == null || activities == null) {
            throw new IllegalArgumentException("Users and activities must not be null");
        }

        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            if (user.getHobbies().isEmpty()) {
                continue;
            }

            for (String hobby : user.getHobbies()) {
                if (activities.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }
        return result;
    }
}
