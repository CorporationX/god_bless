package faang.school.godbless.collectusers;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private Integer age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users,
                                                    Set<String> activities) {
        Map<User, String> resultMap = new HashMap<>();
        users.stream().forEach(user -> user.activities.stream()
                .filter(activities::contains)
                .findFirst()
                .ifPresent(s -> resultMap.put(user, s)));
        return resultMap;
    }
}
