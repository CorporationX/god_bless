package faang.school.godbless.david;

import lombok.Getter;

import java.util.*;
@Getter
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
        Map<User, String> hobby = new HashMap<>();

        for (User user : users) {
            for (String activity : user.getActivities()) {
                if(activities.contains(activity)) {
                    hobby.put(user, activity);
                    break;
                }
            }
        }
        return hobby;
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", activities=" + activities +
                '}';
    }

}
