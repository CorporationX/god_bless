package school.faang.BJS2_79137;

import java.util.*;

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
            int age = user.age;

            if (!result.containsKey(age)) {
                result.put(age, new ArrayList<>());
            }
            result.get(age).add(user);
        }

        return result;
    }


    @Override
    public String toString() {
        return name + ", " + age + ", " + workplace + ", " + address;
    }
}
