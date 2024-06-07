package faang.school.godbless.aged777_BSJ2_collect_users;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record User(int id, String name, int age, @Getter List<String> activities) {

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User currentUser : users) {
            for (String currentActivity : activities) {
                if (currentUser.getActivities().contains(currentActivity)) {
                    result.put(currentUser, currentActivity);
                    return result;
                }
            }
        }
        System.out.println("В списке пользователей таких активностей не найдено.");
        return result; // Map<null, null>
    }
}
