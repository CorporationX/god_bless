package school.faang.sprint1.task_44023;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobby;

    public User(int id, String name, int age, Set<String> hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
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

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetHobbies) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String hobbys : user.getHobby()) {
                if (targetHobbies.contains(hobbys)) {
                    result.put(user, hobbys);
                    break;
                }
            }
        }
        return result;
    }
}

