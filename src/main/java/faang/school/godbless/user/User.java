package faang.school.godbless.user;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record User(int id, String name, int age, Set<String> activity) {
    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> passedActivities) {
        Map<User, String> resultHobbyLovers = new LinkedHashMap<>();
        users.forEach(user -> user.activity.stream()
                .filter(passedActivities::contains)
                .findFirst()
                .ifPresent(hobby -> resultHobbyLovers.put(user, hobby)));
        return resultHobbyLovers;
    }
}

