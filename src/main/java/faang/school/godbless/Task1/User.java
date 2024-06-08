package faang.school.godbless.Task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode

public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    @Override
    public String toString() {
        return name;
    }


    public static HashMap<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.getActivities()) {
                if (hobbies.contains(hobby)) {
                    hobbyLovers.put(user, hobby);
                }
            }
        }
        return (HashMap<User, String>) hobbyLovers;
    }

}
