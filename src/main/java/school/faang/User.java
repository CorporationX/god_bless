package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    public String name;
    public int age;
    public String workplace;
    public String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        for (User user : users){
            List<User> usersInList = usersByAge.get(user.getAge());
            if (usersInList == null) {
                usersInList = new ArrayList<>();
                usersByAge.put(user.getAge(), usersInList);
            }
            usersInList.add(user);
        }

        return usersByAge;
    }

    private int getAge() {
        return this.age;
    }

}


