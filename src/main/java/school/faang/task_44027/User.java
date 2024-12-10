package school.faang.task_44027;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Getter
public class User {
    private String id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public User(String name, int age, Set<String> hobbies) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetHobbies) {
        Map<User, String> result = new HashMap<>();

        for (User user: users) {
            for (String hobby: user.getHobbies()) {
                if (targetHobbies.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }
        return result;
    }
}
