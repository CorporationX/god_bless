package school.faang.bjs2_79190;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
@Data
public class User {
    private static int currentId = 1;

    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public User(String name, int age, Set<String> hobbies) {
        this.id = currentId++;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbiesUsers = new HashMap<>();

        for (User user : users) {
            Set<String> userHobbies = user.getHobbies();
            for (String hobby : hobbies) {
                if (userHobbies.contains(hobby)) {
                    hobbiesUsers.put(user, hobby);
                    break;
                }
            }
        }
        return hobbiesUsers;
    }
}
