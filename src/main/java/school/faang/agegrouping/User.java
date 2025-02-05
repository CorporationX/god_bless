package school.faang.agegrouping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static HashMap<Integer, List<User>> groupingByAge(List<User> users) {
        HashMap<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            if (!result.containsKey(user.age)) {
                result.put(user.age, new ArrayList<>());
            }
            result.get(user.age).add(user);
        }
        return result;
    }
}
