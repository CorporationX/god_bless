package school.faang.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> hobbies;

    public User(int id, String name, int age, Set<String> hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobbies = hobby;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.getHobbies().contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }
}
