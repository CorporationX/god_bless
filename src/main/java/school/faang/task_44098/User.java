package school.faang.task_44098;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private static int idCounter = 0;

    private final int id;
    private final String name;
    private final int age;
    private final Set<String> hobbies;

    public User(String name, int age, Set<String> hobbies) {
        this.id = ++idCounter;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.hobbies.contains(hobby)) {
                    hobbyLovers.put(user, hobby);
                    break;
                }
            }
        }

        return hobbyLovers;
    }
}
