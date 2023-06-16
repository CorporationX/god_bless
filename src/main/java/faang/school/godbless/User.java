package faang.school.godbless;


import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbiesSet) {
        Map<User, String> hobbyLover = new HashMap<>();

        for (User user : users) {
            for (String hobby : user.hobbies) {
                if (hobbiesSet.contains(hobby)) {
                    hobbyLover.put(user, hobby);
                }
            }
        }
        return hobbyLover;
    }

}
