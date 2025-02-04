package school.faang.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;

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
        this.hobbies = (hobbies != null) ? hobbies : new HashSet<>();
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            if (user.getHobbies() == null || user.getHobbies().isEmpty()) {
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
