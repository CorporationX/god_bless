package BJS2_56337;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public record User(UUID id, String name, int age, Set<String> hobbies) {
    public static HashMap<User, String> findHobbyLovers(List<User> users, Set<String> hobbiesToFind) {
        HashMap<User, String> result = new HashMap<>();

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
