package faang.school.godbless.task4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record User(int id, String name, int age, Set<String> activity) {

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> friends = new HashMap<>();
        for (User user : users) {
            for (String actUser : user.activity()) {
                for (String interest : hobbies) {
                    if (actUser.equals(interest)) {
                        friends.put(user, interest);
                        break;
                    }
                }
                if (friends.containsKey(user)) {
                    break;
                }
            }
        }
        return friends;
    }
}
