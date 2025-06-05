package school.faang.collectusers;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(of = {"id", "name", "age"})
public class User {

    private final String id;
    @ToString.Include
    private final String name;
    @ToString.Include
    private final Integer age;
    private Set<String> hobbies = new HashSet<>();

    public static Map<User, String> findHobbyLovers(Set<User> users, Set<String> hobbies) {
        var hobbyLovers = new HashMap<User, String>();
        for (var user : users) {
            for (var hobby : hobbies) {
                if (user.hobbies.contains(hobby)) {
                    hobbyLovers.put(user, hobby);
                }
            }
        }
        return hobbyLovers;
    }

    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }
}
