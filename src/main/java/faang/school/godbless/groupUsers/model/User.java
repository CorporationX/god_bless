package faang.school.godbless.groupUsers.model;

import lombok.Builder;

import java.util.*;

@Builder
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

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> resultHobbiesMap = new HashMap<>();
        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.hobbies.contains(hobby)) {
                    resultHobbiesMap.put(user, hobby);
                    break;
                }
            }
        }
        return resultHobbiesMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
