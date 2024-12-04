package school.faang.bjs243981;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private List<String> hobby;

    public User(int id, String name, int age, List<String> hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public List<String> getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, name=%s, age=%d, hobby=%s}", id, name, age, hobby);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(hobby, user.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, hobby);
    }

    protected static Map<User, String> findHobbyLovers(List<User> users, Set<String> setHobby) {
        Map<User, String> hobbyUser = new HashMap<>();
        for (User user : users) {
            for (String hobby : setHobby) {
                if (user.getHobby().contains(hobby)) {
                    hobbyUser.put(user, hobby);
                }
            }
        }
        return hobbyUser;
    }
}