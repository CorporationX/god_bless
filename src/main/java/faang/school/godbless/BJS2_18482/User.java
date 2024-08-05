package faang.school.godbless.BJS2_18482;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String name;
    private int age;
    private String placeJob;
    private String address;

    public static Map<Integer, List<String>> groupUsers(List<User> users) {
        Map<Integer, List<String>> userMap = new HashMap<>();
        for(User user : users) {
            List userList = userMap.get(user.getAge());
            System.out.println(userList);
            if (userList == null) {
                userList = new ArrayList<>();
                userMap.put(user.getAge(), userList);
            }
            userList.add(user);
        }
        return userMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", placeJob='" + placeJob + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public User(String name, int age, String placeJob, String address) {
        this.name = name;
        this.age = age;
        this.placeJob = placeJob;
        this.address = address;
    }

}
