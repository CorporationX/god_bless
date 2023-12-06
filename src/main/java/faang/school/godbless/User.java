package faang.school.godbless;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbiesSet) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            for (String hobby : user.hobbies) {
                if (hobbiesSet.contains(hobby)) {
                    if (!hobbyLovers.containsKey(user)) {
                        hobbyLovers.put(user, hobby);
                    }
                }
            }
        }
        return hobbyLovers;
    }

}
