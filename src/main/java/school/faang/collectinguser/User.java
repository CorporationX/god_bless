package school.faang.collectinguser;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private final int id;
    private final String name;
    private int age;
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя пользователя не может быть пустым");
        }

        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = new HashSet<>(activities);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
    }

    public void setActivities(Set<String> activities) {
        this.activities = activities;
    }

    public Set<String> getActivities() {
        return Collections.unmodifiableSet(new HashSet<>(activities));
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", activities=" + activities +
                '}';
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetActivities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (targetActivities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        
        return result;
    }
}
