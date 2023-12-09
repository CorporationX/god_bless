package faang.school.godbless.javacore.collectusers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> resultMap = new HashMap<>();
        users.stream().forEach(user ->
                user.getActivities().stream()
                        .filter(activity -> activities.contains(activity))
                        .findFirst()
                        .ifPresent(activity -> resultMap.put(user, activity))
        );
        return resultMap;
    }

}
