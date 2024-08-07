package faang.school.godbless.david;

import lombok.Getter;
import java.util.*;

@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if(!userGroups.containsKey(age)) {
                userGroups.put(age, new ArrayList<>());
            }
            userGroups.get(age).add(user);
        }
        return userGroups;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", workplace='" + workplace + "', address='" + address + "'}";
    }
}
