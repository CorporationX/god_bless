package faang.school.godbless.BJS218596;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String name;
    private Integer age;
    private String placeWork;
    private String address;

    public User(String name, Integer age, String placeWork, String address) {
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public String toString() {
        return String.format("[Name: %s, Age: %d, place work: %s, address: %s]", name, age, placeWork, address);
    }

    public static HashMap<Integer, ArrayList<User>> groupUsers(ArrayList<User> users) {
        HashMap<Integer, ArrayList<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if (!groupUsers.containsKey(age)) {
                groupUsers.put(age, new ArrayList<>());
                groupUsers.get(age).add(user);
            } else {
                groupUsers.get(age).add(user);
            }
        }
        return groupUsers;
    }
}

