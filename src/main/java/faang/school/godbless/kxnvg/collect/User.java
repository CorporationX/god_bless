package faang.school.godbless.kxnvg.collect;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@EqualsAndHashCode
public class User {

    private int userId;
    private String userName;
    private int userAge;
    private Set<String> userActivities;

    public User(int userId, String userName, int userAge, Set<String> userActivities) {
        constructorValidation(userId, userName, userAge);

        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userActivities = userActivities;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> resultMap = new HashMap<>();

        if (activities.isEmpty()) {
            return resultMap;
        }
        for (User user : users) {
            Set<String> activitiesSet = user.getUserActivities();

            for (String string : activities) {
                if (activitiesSet.contains(string)) {
                    resultMap.put(user, string);
                    break;
                }
            }
        }

        return resultMap;
    }

    private void constructorValidation(int id, String name, int age) {
        if (id < 1) {
            throw new IllegalArgumentException("Id не может быть меньше 1");
        } else if (name == null || name == "") {
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть меньше 0");
        }
    }
}
