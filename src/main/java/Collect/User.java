package Collect;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(String name, Set<String> activities) {
        this.name = name;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> arr, Set<String> activ) {
        HashMap<User, String> ans = new HashMap<>();
        for (User elem1 : arr) {
            for (String elem2 : elem1.activities()) {
                if (activ.contains(elem2)) {
                    ans.put(elem1, elem2);
                    break;
                }
            }
        }
        return ans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(activities, user.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, activities);
    }

    public Set<String> activities() {
        return activities;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", activities=" + activities +
                '}';
    }
}
