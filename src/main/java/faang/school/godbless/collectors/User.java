package faang.school.godbless.collectors;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> map = new HashMap<>();
        users.forEach(user -> {
            Iterator<String> iterator = activities.iterator();
            while (iterator.hasNext()) {
                String activity = iterator.next();
                if (user.getActivities().contains(activity)) {
                    map.put(user, activity);
                    break;
                }
            }
        });
        return map;
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

    public void setAddActivities(String activities) {
        this.activities.add(activities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        int num = 31;
        return num * Objects.hash(id, name, age);
    }
}
