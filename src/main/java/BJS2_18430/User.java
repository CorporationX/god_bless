package BJS2_18430;

import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
public class User {

    //Поправил модификаторы на private
    private int id;
    private String name;
    private int age;
    private Set<String> userActivities;

    public User(int id, String name, int age, Set<String> userActivities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userActivities = userActivities;
    }

    //Если речь про реализацию через интерфейс то поправил ниже (ожидаемый возврат и инициализация)
    //Поправил логику метода + добавил геттер для множества активностей User-а
    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> allActivities) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            for (String activity : user.getUserActivities()) {
                if (allActivities.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }

    public Set<String> getUserActivities() {
        return userActivities;
    }

}
