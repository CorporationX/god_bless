package school.faang.BJS2_85507;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
public class User {
    private Long id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public static HashMap<User, String> findHobbyLovers(Set<User> users, List<String> hobbies) throws Exception {
        HashMap<User, String> usersAndTheirHobbies = new HashMap<>();
        if (users == null || hobbies == null || users.isEmpty() || hobbies.isEmpty()) {
            throw new Exception("Список пуст или не существует.");
        }
        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.hobbies.contains(hobby)) {
                    usersAndTheirHobbies.put(user, hobby);
                    break;
                }
            }
        }
        return usersAndTheirHobbies;
    }
}
