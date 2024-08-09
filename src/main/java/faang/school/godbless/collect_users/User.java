package faang.school.godbless.collect_users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> actions;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {

        if (users == null || hobbies == null || users.isEmpty() || hobbies.isEmpty()) {
            throw new IllegalArgumentException("Either users or hobbies was empty/null.");
        }

        Map<User, String> userHobbyMatch = new HashMap<>();
        for (User user : users) {
            Optional<String> hobbyOptional = user.getActions().stream().filter(hobbies::contains).findFirst();
            hobbyOptional.ifPresent(hobby -> userHobbyMatch.put(user, hobby));
        }

        return userHobbyMatch;
    }
}
