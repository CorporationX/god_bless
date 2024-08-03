package faang.school.godbless.BJS2_18399;

import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class User {

    private int id;
    private String name;
    private int age;
    private HashSet<String> hobbies;

    public User(int id, String name, int age, HashSet<String> hobbies) {
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
    public HashSet<String> getHobbies() {
        return hobbies;
    }

    public static HashMap<User, String> findHobbyLovers(List<User> users, HashSet<String> hobbies) {
        HashMap<User, String> hobbyLoversMap = new HashMap<>();
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
