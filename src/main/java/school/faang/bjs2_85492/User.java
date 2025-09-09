package school.faang.bjs2_85492;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<String, String> findHobbyLovers(List<User> users, Set<String> targetActivitie) {
        Map<String, String> resultMap = new HashMap<>();

        for (User user : users) {
            Set<String> userActivitie = user.activities; //берем интересы юзера

            for (String activity : userActivitie) { //берем активность юзера
                if (targetActivitie.contains(activity)) { //проверяем на наличие в списке
                    resultMap.put(user.name, activity);
                    break;
                }
            }
        }
        return resultMap;
    }
}
