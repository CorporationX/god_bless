package faang.school.godbless.GroupPeople;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String name;
    private int age;
    private String company;
    private String adress;

    public User(String name, int age, String company, String adress) {
        this.name = name;
        this.age = age;
        this.company = company;
        this.adress = adress;
    }

    public static Map<Integer, List<User>> groupUser(List<User> usersList) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : usersList) {
            if (!(groupedUsers.containsKey(user.age))) {
                groupedUsers.put(user.age, new ArrayList<>());
            }
            groupedUsers.get(user.age).add(user);
        }
        return groupedUsers;
    }
}