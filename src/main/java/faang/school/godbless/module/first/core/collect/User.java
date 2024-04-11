package faang.school.godbless.module.first.core.collect;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;
    
    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> resultUserMap = new HashMap<>();
        users.forEach(user -> {
            if (Collections.disjoint(user.getActivities(), activities)) {
                return;
            }
            resultUserMap.computeIfAbsent(user, value -> user.getActivities().get(0));
        });
        return resultUserMap;
    }
}
