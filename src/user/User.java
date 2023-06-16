package user;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address){
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : usersList) {
            int age = user.getAge();
            if (groupedUsers.containsKey(age)) {
                groupedUsers.get(age).add(user);
            } else {
                List<User> usersWithSameAge = new ArrayList<>();
                usersWithSameAge.add(user);
                groupedUsers.put(age, usersWithSameAge);
            }
        }
        return groupedUsers;
    }
    public int getAge() {
        return age;
    }

    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
