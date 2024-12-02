package school.faang;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    @Getter
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByGroup = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (age > 100) {
                System.out.println("Incorrect age: " + user);
            }

            if (!usersByGroup.containsKey(age)) {
                usersByGroup.put(age, new ArrayList<>());
            }
            usersByGroup.get(age).add(user);
        }
        return usersByGroup;
    }
}
