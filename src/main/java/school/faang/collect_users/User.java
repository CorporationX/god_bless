package school.faang.collect_users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> listOfUsers, Set<String> targetHobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : listOfUsers) {
            for (String hobby : user.getHobbies()) {
                if (targetHobbies.contains(hobby)) {
                    hobbyLovers.put(user, hobby);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}
