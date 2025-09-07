package school.faang.bjs2_85492;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<String, String> findHobbyLovers(List<User> users, Set<String> targetActivitie) {
        Map<String, String> resultMap = new HashMap<>(); // Создание пустого мапа для вывода результатов

        //Перебираем юзеров
        for (User user : users) {
            Set<String> userActivitie = user.getActivities();

            for (String activity : userActivitie) {
                if (targetActivitie.contains(activity)) {
                    resultMap.put(user.name, activity);
                    break;
                }
            }
        }
        return resultMap;
    }

    public User(int id, String name, int age, Set<String> activitie) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activitie;
    }

    public Set<String> getActivities() {
        return activities;
    }
}
