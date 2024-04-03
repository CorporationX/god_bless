package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String placeWork;
    private String address;

    User(String name, int age, String placeWork, String address) {
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupUser = new HashMap<>();

        for (User user : userList) {
            int key = user.getAge();
            if (!groupUser.containsKey(key)) {
                groupUser.put(key, new ArrayList<>());
            }
            groupUser.get(key).add(user);
        }
        return groupUser;


    }

    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getPlaceWork() {
        return this.placeWork;
    }
    public String getAddress() {
        return this.address;
    }
    public void setName(int age) {
        this.age = age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPlaceWork(int age) {
        this.age = age;
    }
    public void setAddress(int age) {
        this.age = age;
    }
}
