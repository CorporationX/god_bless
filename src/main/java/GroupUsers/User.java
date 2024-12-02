package GroupUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name,
                   workplace,
                   address;
    private int age;

    public User(String name, String workplace, String address, int age) {
        this.name = name;
        this.workplace = workplace;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (User user: users) {
            if (usersMap.containsKey(user.getAge())) {
                usersMap.get(user.getAge()).add(user);
            } else {
                usersMap.put(user.getAge(), new ArrayList<>());
            }
        }
        return usersMap;
    }
}
