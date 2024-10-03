package school.faang.collect_users;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private int age;
    private Set<String> hobbies;

    static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) throws NoSuchElementException {

        var hobbyLovers = new HashMap<User, String>();
        String hobby = hobbies.stream().findFirst().orElseThrow(() -> new NoSuchElementException("Hobby not exists"));
        users.forEach(user -> {
            if (user.getHobbies().contains(hobby)) {
                hobbyLovers.put(user, hobby);
            }
        });
        return hobbyLovers;
    }
}
