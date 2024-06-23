package faang.school.godbless.sprint_1.java_core.task_005;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record User(int id, String name, int age, Set<String> hobbies) {

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            Set<String> userHobbies = user.hobbies();

            for (String hobby : hobbies) {
                if (userHobbies.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }

        }
        return result;
    }
}
