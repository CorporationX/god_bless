package school.faang.BJS2_85507;

import java.util.HashMap;
import java.util.List;

public class User {
    Long id;
    String name;
    Long age;
    List<String> hobbies;

    public static HashMap<User, String> findHobbyLovers(User[] users, String[] hobbies) {
        HashMap<User, String> usersAndTheirHobbies = new HashMap<>();
        if (users != null && hobbies != null && users.length > 0 && hobbies.length > 0) {
            for (User user : users) {
                for (String hobby : hobbies) {
                    if (user.hobbies.contains(hobby)) {
                        usersAndTheirHobbies.put(user, hobby);
                    }
                }
            }
        }
        return usersAndTheirHobbies;
    }
}
