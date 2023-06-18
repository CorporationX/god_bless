package collecting.users;


import lombok.*;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private int id;
    private String name;
    private int age;

    private Set<String> activities ;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.activities.contains(activity)) {
                    map.put(user, activity);
                }
            }
        }
        return map;
    }
}
