package school.faang.task_43969;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private Long id;
    private String name;
    private int age;
    @Getter
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        users.forEach(user -> {
            for (String hobby : hobbies) {
                if (user.getHobbies().contains(hobby)) {
                    hobbyLovers.put(user, hobby);
                    break;
                }
            }
        });
        return hobbyLovers;
    }
}
