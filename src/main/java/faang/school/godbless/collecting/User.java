package faang.school.godbless.collecting;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Setter
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public HashMap<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        HashMap<User, String> result = new HashMap<>();
        for (String hobby : hobbies) {
            for (User user : users) {
                if (user.getHobbies().contains(hobby)) {
                    result.put(user, hobby);
                }
            }
        }
        return result;
    }
}
