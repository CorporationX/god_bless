package faang.school.godbless.r_edzie.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public Map<User, String> findHobbyLovers(ArrayList<User> users, Set<String> hobbies) {
        Map<User, String> collection = new HashMap<>();

        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.hobbies.contains(hobby)) {
                    collection.put(user, hobby);
                    break;
                }
            }
        }

        return collection;
    }
}
