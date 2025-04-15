package school.faang.bjs268064;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Data
public class User {
    private final String name;
    private final int age;
    private final int id;
    private final Set<String> hobbies;
    private static int counter = 0;

    public User(String name, int age, Set<String> hobbies) {
        if (name == null || name.isBlank()) {
            log.error("Name cannot be null or blank");
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
        if (age < 0 || age > 110) {
            log.error("Age cannot be negative or greater than 110");
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
        if (hobbies == null || hobbies.isEmpty()) {
            log.error("Hobbies cannot be null or empty");
            throw new IllegalArgumentException("Hobbies cannot be null or empty");
        }
        this.hobbies = hobbies;
        this.id = ++counter;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                if (hobbies.contains(hobby)) {
                    result.put(user, hobby);
                }
            }
        }
        return result;
    }
}
