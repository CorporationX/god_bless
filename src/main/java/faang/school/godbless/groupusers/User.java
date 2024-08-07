package faang.school.godbless.groupusers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        if (usersList == null) {
            throw new IllegalArgumentException("usersList cannot be null");
        }

        Map<Integer, List<User>> usersGroupedByAge = new HashMap<>();
        for (User user : usersList) {
            int userAge = user.getAge();
            if (!usersGroupedByAge.containsKey(userAge)) {
                usersGroupedByAge.put(userAge, new ArrayList<>());
            }
            usersGroupedByAge.get(userAge).add(user);
        }
        return usersGroupedByAge;
    }
}
