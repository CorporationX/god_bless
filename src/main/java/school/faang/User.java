package school.faang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

    Long id;
    String name;
    int age;
    Set<String> activities;

    Map<User, String> findHobbyLovers(List<User> people, Set<String> activities) {
/*     Метод должен в переданном списке пользователей находить тех,
       у кого в ИХ множестве активностей есть хотя бы один элемент из переданного в метод множества активностей.
       Если так, то сохранить этого пользователя в виде ключа в результирующую мапу,
       а значением ему выставить первую совпавшую активность в двух множествах. */

        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user: people){
            for (String activity: activities){
                if (user.activities.contains(activity)){
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}
