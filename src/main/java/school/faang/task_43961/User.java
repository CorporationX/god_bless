package school.faang.task_43961;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<User, String>();

        for (User user : users) {
            String match = hobbies.stream()
                    .filter(user.hobbies::contains)
                    .findFirst()
                    .orElse("no matches");
            hobbyLovers.put(user, match);
        }

        return hobbyLovers;
    }
}
