package school.faang.s12task43996;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name", "age", "hobbies"})
@Getter
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> usersHobbies = new HashMap<>();

        for (User user : users) {
            for (String hobby : hobbies) {

                if (user.getHobbies().contains(hobby)) {
                    usersHobbies.put(user, hobby);
                    break;
                }
            }
        }
        return usersHobbies;
    }
}