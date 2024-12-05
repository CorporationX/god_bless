package school.faang.sprint1.task_43984;

import java.util.*;

public class User {
    private int age;
    private String name;
    private String address;
    private String workplace;


    public User(int age, String name, String address, String workplace) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.workplace = workplace;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            if (!userGroups.containsKey(user.age)) {
                ArrayList<User> userGroup = new ArrayList<>();
                userGroups.put(user.age, userGroup);
            }
            userGroups.get(user.age).add(user);
        }
        return userGroups;
    }

}
