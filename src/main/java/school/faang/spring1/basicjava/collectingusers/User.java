package school.faang.spring1.basicjava.collectingusers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> userHobbies;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> map = new HashMap<>();
        for(User user : users) {
            for (String hobby : user.getUserHobbies()) {
                if (hobbies.contains(hobby)) {
                    map.put(user, hobby);
                    break;
                }
            }
        }
        return map;
    }
}
