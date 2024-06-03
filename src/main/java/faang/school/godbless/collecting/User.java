package faang.school.godbless.collecting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record User(long id, String name, int age, Set<String> hobbies) {

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> usersHobbies = new HashMap<>();
        users.forEach(user ->
                usersHobbies.computeIfAbsent(user, u -> hobbies.stream()
                        .filter(u.hobbies::contains)
                        .findFirst()
                        .orElse(null)));
        return usersHobbies;
    }

}
