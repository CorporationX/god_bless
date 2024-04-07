package faang.school.godbless.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> foundHobbies = new HashMap<>();

        for (User user : users) {
            Set<String> userActivities = user.getActivities();
            for (String hobby : hobbies) {
                if (userActivities.contains(hobby)) {
                    foundHobbies.put(user, hobby);
                    break;
                }
            }
        }
        return foundHobbies;
    }
}
