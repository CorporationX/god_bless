package faang.school.godbless.task4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record User(int id, String name, int age, Set<String> activity) {

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> friends = new HashMap<>();
        for (User user : users) {
            for (String interest : hobbies) {
                if (user.activity().contains(interest)) {
                    friends.put(user, interest);
                    break;
                }
            }
        }
        return friends;
    }
}
