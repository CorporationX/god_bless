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

        // Guard
        if (users == null || hobbies == null || users.isEmpty() || hobbies.isEmpty()) {
            throw new IllegalArgumentException("Either users or hobbies was empty/null.");
        }

        /*
            For each user, check filter if an action is present in a provided hobby list - optional is used when returning
            the first matching hobby (for case of no matches)
         */
        Map<User, String> userHobbyMap = new HashMap<>();
        for (User user : users) {
            Optional<String> hobbyOptional = user.getActions().stream().filter(hobbies::contains).findFirst();
            hobbyOptional.ifPresent(s -> userHobbyMap.put(user, s));
        }

        return userHobbyMap;
    }
}
