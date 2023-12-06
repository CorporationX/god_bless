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


    public static Map<User, String> findHobbyLovers (List<User> users, Set<String> activities){
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
                }
            }
        }
        //Возвращаем мапу
        return foundedUsers;
    }

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<String> getActivities() {
        return activities;
    }

    public void setActivities(Set<String> activities) {
        this.activities = activities;
    }
}
