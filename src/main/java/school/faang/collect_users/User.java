package school.faang.collect_users;

import lombok.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> userHobbies;

    public User(int id, String name, int age, Set<String> userHobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userHobbies = userHobbies;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.userHobbies) {
                if (hobbies.contains(hobby)) {
                    hobbyLovers.put(user, hobby);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}
