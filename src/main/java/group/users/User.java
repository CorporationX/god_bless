package group.users;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.putIfAbsent(user.getAge(), new ArrayList<>());
            groupedUsers.get(user.getAge()).add(user);
        }
        return groupedUsers;
    }

    public static void printResult(Map<Integer, List<User>> map) {
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            for (User user : entry.getValue()) {
                System.out.println("Возраст: " + entry.getKey() + " лет" + "\n" + "Имя: " + user.getName() + "\n");
            }
        }
    }
}
