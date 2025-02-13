package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public record User(UUID id, String name, int age, HashSet<String> hobbies) {
    public static HashMap<User, String> findHobbyLovers(ArrayList<User> users, HashSet<String> hobbiesToFind) {
        var result = new HashMap<User, String>();

        for (User user : users) {
            for (String userHobby : user.hobbies()) {
                if (hobbiesToFind.contains(userHobby)) {
                    // У пользователя есть хобби => добавляем в результат и конец
                    result.put(user, userHobby);

                    break;
                }
            }
        }

        return result;
    }
}
