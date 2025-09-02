package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    String name;
    int age;
    String workplace;
    String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;

    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : users) {
            int userAge = user.age;

            if (!result.containsKey(userAge)) {
                result.put(userAge, new ArrayList<>());
            }
            result.get(userAge).add(user);
        }
        return result;
    }

    public String toString() {
        return name + " " + age + " " + workplace + " " + address;
    }
}
