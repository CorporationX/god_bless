package faang.school.godbless.bc223;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final String name;
    private final int age;
    private final String workPlace;
    private final String address;

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
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
        return String.format("Name: %s, Age: %d, Work place: %s, Adress: %s", name, age, workPlace, address);
    }
}