package school.faang;

import java.util.*;
import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class User {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetActivities) {
        Map<User, String> result = new HashMap<>();

        // Проходим по всем пользователям
        for (User user : users) {
            // Для каждого пользователя проверяем его активности
            for (String userActivity : user.getActivities()) {
                // Если активность пользователя есть в целевом множестве
                if (targetActivities.contains(userActivity)) {
                    // Добавляем пользователя и первую найденную активность
                    result.put(user, userActivity);
                    break; // Прерываем внутренний цикл после первого совпадения
                }
            }
        }
        return result;
    }
}