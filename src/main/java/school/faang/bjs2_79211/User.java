package school.faang.bjs2_79211;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> resultMap = new HashMap<>();

        for (User user : userList) {
            if (!resultMap.containsKey(user.getAge())) {
                resultMap.put(user.getAge(), new ArrayList<>());
                resultMap.get(user.getAge()).add(user);
            } else {
                resultMap.get(user.getAge()).add(user);
            }
        }

        return resultMap;
    }
}
