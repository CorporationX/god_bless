package faang.school.My_Package;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
@ToString

public class User {
    private int id;
    private int age;
    private String name;
    private Set<String> activities;

    public User() {
    }

    public User(int id, int age, String name, Set<String> activities) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.activities = activities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getActivities() {
        return activities;
    }

    public void setActivities(Set<String> activities) {
        this.activities = activities;
    }


    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbies = new HashMap<>();

        for (User human : users) {    // цикл в котором перебираю пользователей
            for (String activ : activities) {
                if (human.getActivities().contains(activ)) {
                    hobbies.put(human, activ);
                }

            }
            //Set<String> intersection = new HashSet<>(Humans); // делаю новый хэш сет копию этих активностей
            // intersection.retainAll(activities);//вырезаю из этого сета все несовпадающие активности
            //if (!intersection.isEmpty()) {

            // hobbies.put(human,)

            // }
            // }

            // Создание множества для хранения общих элементов
            // Set<Integer> intersection = new HashSet<>();
            //intersection.retainAll(activities);

        }
        return hobbies;
    }
}





