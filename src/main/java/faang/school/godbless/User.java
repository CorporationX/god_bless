package faang.school.godbless;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class User {
    private String name;
    private int age;
    private String workPlace;
    String adress;

    public User(String name, int age, String workPlace, String address){
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.adress = adress;

    }

    static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> usersAge = new HashMap<>();

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            int age = user.age;
            if (!usersAge.containsKey(age)) {
                usersAge.put(age, new ArrayList<>());
            }
            usersAge.get(age).add(user);
        }
        return usersAge;
    }
}
