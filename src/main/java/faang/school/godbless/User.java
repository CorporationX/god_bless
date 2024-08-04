package faang.school.godbless;

import lombok.*;
import java.util.*;

@Data
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private int age;
    private Set<String> hobbies;

    private Set<String> findHobbies(Set<String> hobbies) {
        Set<String> result = new HashSet<>(this.hobbies);
        result.retainAll(hobbies);
        return result;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();

        if (users.isEmpty() || hobbies.isEmpty()) {
            return result;
        }

        for (User user : users) {
            Set<String> usersHobbies = user.findHobbies(hobbies);
            usersHobbies.stream().findAny().ifPresent(hobby -> result.put(user, hobby));
        }

        return result;
    }
}