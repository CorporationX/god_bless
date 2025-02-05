package school.faang;

import java.util.*;

public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> sortedUsers = new HashMap<>();
        for (User user : users) {
            if (!sortedUsers.containsKey(user.getAge())) {
                sortedUsers.put(user.getAge(), new ArrayList<>());
            }
            sortedUsers.get(user.getAge()).add(user);
        }
        return sortedUsers;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User {" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", workplace = '" + workplace + '\'' +
                ", address = '" + address + '\'' +
                '}';
    }
}