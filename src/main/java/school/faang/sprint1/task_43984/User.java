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

    public static Map<Integer, ? extends List<User>> groupUsers(List<User> users) {
        Map<Integer, ArrayList<User>> userGroups = new HashMap<>();
        for (User user : users) {
            if (!userGroups.containsKey(user.age)) {
                ArrayList<User> userGroup = new ArrayList<>();
                userGroup.add(user);
                userGroups.put(user.age, userGroup);
            } else {
                userGroups.get(user.age).add(user);
            }
        }
        return userGroups;
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList(
            Arrays.asList(new User(
                    25,
                    "rauan",
                    "kz",
                    "remote"
            ), new User(
                    39,
                    "John",
                    "us",
                    "office"
            ), new User(
                    23,
                    "Dimash",
                    "kz",
                    "office"
            ), new User(
                    25,
                    "Sam",
                    "uk",
                    "remote"
            ))
        );
        System.out.printf(
            "result %s",
            groupUsers(users)
        );
    }
}
