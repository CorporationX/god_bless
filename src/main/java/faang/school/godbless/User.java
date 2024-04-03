package src.main.java.faang.school.godbless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {

    private int id;

    private String name;
    private byte age;
    private Set<String> activity;

    public User(int id, String name, byte age, Set<String> activity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activity = activity;
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

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public Set<String> getActivity() {
        return activity;
    }

    public void setActivity(Set<String> activity) {
        this.activity = activity;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activityes) {
        Map<User, String> LoveHobby = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.activity) {
                if (activityes.contains(hobby)) {
                    LoveHobby.put(user, hobby);
                    break;
                }
            }
        }
        return LoveHobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(activity, user.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, activity);
    }
}
