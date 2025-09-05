package school.faang.BJS2_85507;

import java.util.HashMap;
import java.util.List;

public class User {
    int id;
    String name;
    int age;
    List<String> hobbies;

    public static HashMap<User, String> findHobbyLovers(User[] users, String[] hobbies) {
        HashMap<User, String> usersWithTheseHobbies = new HashMap<>();
        if (users != null && hobbies != null && users.length > 0 && hobbies.length > 0) {
            for (User user : users) {
                for (String hobby : hobbies) {
                    if (user.hobbies.contains(hobby)) {
                        usersWithTheseHobbies.put(user, hobby);
                    }
                }
            }
        }
        return usersWithTheseHobbies;
    }
}
