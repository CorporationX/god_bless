package school.faang.collectionusers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> activities;

    /**
     * Метод для поиска пользователей, у которых есть совпадения по активностям.
     *
     * @param users      Список пользователей.
     * @param hobbies Множество активностей для поиска.
     * @return Мапа, где ключ — пользователь, значение — совпавшая активность.
     */
    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.getActivities()) {
                if (hobbies.contains(hobby)) {
                    hobbyLovers.put(user, hobby);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}