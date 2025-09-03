package school.faang.bjs2_85476;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.List;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public User(int id, String name, int age, Set<String> hobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public Set<String> getActivities() {
        return hobbies;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.hobbies) {
                if (activities.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}
