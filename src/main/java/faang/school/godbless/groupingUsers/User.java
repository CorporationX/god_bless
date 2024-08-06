package faang.school.godbless.groupingUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public int getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupingByAge = new HashMap<>();
        users.forEach(user -> groupingByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user));
        return groupingByAge;
    }
}
