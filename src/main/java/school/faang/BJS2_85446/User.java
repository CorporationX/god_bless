package school.faang.BJS2_85446;

import java.util.*;

public class User {
    long id;
    String name;
    int age;
    Set<String> hobbies;

    public User(long id, String name, int age, Set<String> hobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            Optional<String> hobby = user.hobbies.stream().filter(hobbies::contains).findAny();
            hobby.ifPresent(s -> result.put(user, s));
        }
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
