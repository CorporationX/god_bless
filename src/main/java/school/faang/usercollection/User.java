package school.faang.usercollection;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@ToString
public class User {
    private static int uniqueId;
    private int id;
    private String name;
    private int age;
    private final Set<String> hobbies;

    public User(String name, int age, Set<String> hobbies) {
        this.id = uniqueId++;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                if (hobbies.contains(hobby)) {
                    map.put(user, hobby);
                    break;
                }
            }
        }
        return map;
    }
}
