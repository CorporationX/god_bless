package faang.school.godbless.task_1;

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

    public static Map<Integer, List<User>> usersGroup(List<User> userList) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : userList) {
            int age = user.age;
            if (groupUsers.containsKey(age)) {
                groupUsers.get(age).add(user);
            } else {
                List<User> anotherList = new ArrayList<>();
                anotherList.add(user);
                groupUsers.put(age, anotherList);
            }
        }
        return groupUsers;
    }
}
