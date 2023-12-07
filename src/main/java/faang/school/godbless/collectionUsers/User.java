package faang.school.godbless.collectionUsers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies = new HashSet<>();

    public Set<String> getHobbies() {
        return hobbies;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> groupHobbyLovers = new HashMap();
        for(User user: users) {
            for(String hobby: user.getHobbies()) {
                if (activities.contains(hobby)) {
                    groupHobbyLovers.putIfAbsent(user, hobby);
                    break;
                }
            }
        }
        return groupHobbyLovers;
    }
}
