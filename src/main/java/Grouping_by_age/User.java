package Grouping_by_age;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> mapUser = new HashMap<>();
        for (int i = 0; i < userList.size(); i++) {
            if (mapUser.containsKey(userList.get(i).age)) {
                mapUser.get(userList.get(i).age).add(userList.get(i));
            }
            else {
                List<User> users1 = new ArrayList<>();
                users1.add(userList.get(i));
                mapUser.put(userList.get(i).age, users1);
            }
        }
        return mapUser;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
