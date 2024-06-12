package faang.school.godbless.CollectingUsers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private long id;
    private String name;
    private int age;
    private List<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> activities) {
        Map<User, String> usersHobby = new HashMap<>();

        for (User currentUser : users) {
            for (String activity : activities) {
                if (currentUser.activities.contains(activity)) {
                    usersHobby.put(currentUser, activity);
                    break;
                }
            }
        }

        return usersHobby;
    }

    public User(long id, String name, int age, List<String> activities) {
        this.setId(id);
        this.setName(name);
        this.setAge(age);
        this.setActivities(activities);
    }

    public void setId(long id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException(id + " is incorrect id");
        }
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException(name + " name is empty");
        }
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 200) {
            this.age = age;
        } else {
            throw new IllegalArgumentException(age + " is incorrect age");
        }
    }

    public void setActivities(List<String> activities) {
        if (!activities.isEmpty()) {
            this.activities = activities;
        } else {
            throw new IllegalArgumentException(activities + " activities is empty");
        }
    }

    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public List<String> getActivities(){
        return this.activities;
    }

    @Override
    public String toString() {
        return "|" + this.id + "| name: " + this.name + ", age: " + this.age +
                ", activity: " + this.activities;
    }
}