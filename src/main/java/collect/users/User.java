package collect.users;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        if (Objects.isNull(users) || Objects.isNull(hobbies)) {
            throw new IllegalArgumentException("Collections might be not null!");
        }
        Map<User, String> usersAndHobbies = new HashMap<>();
        for (User user : users) {
            if (!Collections.disjoint(user.getHobbies(), hobbies)) {
                String commonHobby = user.getHobbies().stream()
                        .filter(hobbies::contains).findFirst().get();
                usersAndHobbies.putIfAbsent(user, commonHobby);
            }
        }
        return usersAndHobbies;
    }
}
