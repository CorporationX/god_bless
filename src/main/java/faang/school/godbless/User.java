package main.java.faang.school.godbless;

import lombok.Data;

import java.util.*;

@Data
public class User {
    private int id;
    private int age;
    private String name;
    private Set<String> activities;
    public User(int id, int age, String name, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            for (String activity : user.activities) {
                if (activities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", activities=" + activities +
                '}';
    }
}

