package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userData) {
        Map<Integer, List<User>> result = new HashMap<>();
        List<User> users;

        for (User user : userData) {
            if (!result.containsKey(user.age)) {
                users = new ArrayList<>();
                users.add(user);
                result.put(user.age, users);
            }
            else {
                users = result.get(user.age);
                users.add(user);
            }
        }
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getWorkPlace() {
        return this.workPlace;
    }

    public String getAddress() {
        return this.address;
    }
}