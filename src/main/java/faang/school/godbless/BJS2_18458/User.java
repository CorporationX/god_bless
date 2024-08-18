package faang.school.godbless.BJS2_18458;

import lombok.Data;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    /**
     * Метод находит пользователей, у которых есть хотя бы одна активность,
     * совпадающая с переданными в метод.
     *
     * @param users        список пользователей для поиска
     * @param targetHobbies множество активностей для поиска совпадений
     * @return мапа, где ключ — пользователь, значение — первая совпавшая активность
     */
    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetHobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (targetHobbies.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}
