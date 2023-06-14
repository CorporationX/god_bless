package faang.school.godbless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private static int id = 1;
    private String name;
    private int age;
    private List<String> hobbies;

    public User(String name, int age, List<String> hobbies) {
        id++;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> hobbies) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.hobbies) {
                if (hobbies.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }
        return result;
    }
}
