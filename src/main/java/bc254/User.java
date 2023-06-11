package bc254;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final String name;
    private final int age;
    private final String placeWork;
    private final String address;

    public User(String name, int age, String placeWork, String address) {
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            int age = user.age;

            if (groupUsers.containsKey(age))
                groupUsers.get(age).add(user);
            else {
                List<User> newGroup = new ArrayList<>();
                groupUsers.put(age, newGroup);
                newGroup.add(user);
            }
        }
        return groupUsers;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, Возраст: %d, Место работы: %s, Адрес: %s", name, age, placeWork, address);
    }
}
