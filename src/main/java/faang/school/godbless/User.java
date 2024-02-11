package faang.school.godbless;

import java.util.*;

public class User {

    private int age;
    private String name, placeOfWork, address;

    User(String name, String placeOfWork, String address, int age) {
        this.name = name;
        this.placeOfWork = placeOfWork;
        this.age = age;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();


        for (User user : users) {//Вносим возраст и списки пользователй

            if (groupUsers.containsKey(user.age)) {
                List<User> ageAppropriateUser = groupUsers.get(user.age);
                ageAppropriateUser.add(user);
                groupUsers.put(user.age, ageAppropriateUser);
            }
            else {
                List<User> ageAppropriateUser = new ArrayList<>();
                ageAppropriateUser.add(user);
                groupUsers.put(user.age, ageAppropriateUser);
            }

        }
        return groupUsers;
    }
}

