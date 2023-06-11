package faang.school.godbless.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    String name;
    int age;
    String job;
    String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userAgeToUsers = new HashMap<Integer, List<User>>();

        for (User user : users) {
            int age = user.age;

            if (userAgeToUsers.get(age) instanceof ArrayList<User>) {
                userAgeToUsers.get(age).add(user);
            } else {
                List<User> newUsers = new ArrayList<User>();
                newUsers.add(user);

                userAgeToUsers.put(age, newUsers);
            }
        }

        return userAgeToUsers;
    }
}
