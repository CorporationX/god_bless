package faang.school.godbless.BJS2_7179;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static HashMap<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        HashMap<User, String> result = new HashMap<>();
        for (User user : users) {
            Set<String> cross = new HashSet<>(user.activities);
            cross.retainAll(activities);
            var crossValue = cross.stream().findFirst();
            if (!crossValue.isEmpty()) {
                result.put(user, crossValue.toString());
            }
        }
        return result;
    }
}
