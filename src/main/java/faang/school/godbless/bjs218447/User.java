package faang.school.godbless.bjs218447;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    private Long id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<Long, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<Long, String> hobbies = new HashMap<>();
        for (User user : users) {
            Set<String> usersHobbies = user.getActivities();
            for (String hobby : usersHobbies) {
                if (activities.contains(hobby)) {
                    hobbies.put(user.getId(), hobby);
                    break;
                }
            }
        }
        return hobbies;
    }
}
