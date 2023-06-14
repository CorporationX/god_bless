package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public int getAge() {
        return age;
    }

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupedUserMap = new HashMap<>();
        for (User user : userList) {
            int age = user.getAge();
            if (!groupedUserMap.containsKey(age)) {
                groupedUserMap.put(age, new ArrayList<>());
            }
            groupedUserMap.get(age).add(user);
        }
        return groupedUserMap;
    }
}





