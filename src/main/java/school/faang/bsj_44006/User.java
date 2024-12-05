package school.faang.bsj_44006;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    int id;
    String name;
    int age;
    Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> usersByHobbies = new HashMap<>();

        for (var user : users) {
            Optional<String> foundedHobbies = findUsersHobbyFromSet(user.getHobbies(), hobbies);
            foundedHobbies.ifPresent(s -> usersByHobbies.put(user, s));
        }

        return usersByHobbies;
    }

    private static Optional<String> findUsersHobbyFromSet(Set<String> usersHobbies, Set<String> givenHobbies) {
        return usersHobbies.stream().filter(givenHobbies::contains).findFirst();
    }
}
