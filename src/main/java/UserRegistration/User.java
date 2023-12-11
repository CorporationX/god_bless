package UserRegistration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        //Создать мапу для финального ответа
        Map<User, String> foundedUsers = new HashMap<>();

        //ЦИКЛ Пройтись по каждому пользователю
        for (User user : users) {
            //  ЦИКЛ Пройтись по каждому элементу сета activites у текущего пользователя
            for (String activity : user.activities) {
                //      ЕСЛИ текущая активность есть в искомом списке
                if (activities.contains(activity)) {
                    //          Сохраняем пользователя в мапу, прерываем цикл
                    foundedUsers.put(user, activity);
                    break;
                }
            }
        }
        //Возвращаем мапу
        return foundedUsers;
    }

}
