package faang.school.godbless.BJS2_18399;

import lombok.Getter;

import java.util.*;

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

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Set<String> getHobbies() {
        return hobbies;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLoversMap = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.hobbies) {
                if (hobbies.contains(hobby)) {
                    hobbyLoversMap.put(user, hobby);
                    break;
                }
            }
        }
        return hobbyLoversMap;
    }
}
