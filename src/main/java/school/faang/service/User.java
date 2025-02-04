package school.faang.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String placeWork;
    private String address;

    public User(String name, int age, String placeWork, String address) {
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userAge = new HashMap<>();
        for (User user : users) {
            userAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        for (Map.Entry<Integer, List<User>> value : userAge.entrySet())
            for (int i = 0; i < value.getValue().size(); i++) {
                System.out.println(value.getKey() + " " + value.getValue().get(i).getName());
            }
        return userAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlaceWork() {
        return placeWork;
    }

    public void setPlaceWork(String placeWork) {
        this.placeWork = placeWork;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

