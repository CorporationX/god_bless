package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Jin", 25, "Google", "Amsterdam"));
        users.add(new User("Namjoon", 30, "Uber", "New York"));
        users.add(new User("V", 25, "Amazon", "London"));
        users.add(new User("J-hope", 35, "Uber", "London"));
        users.add(new User("Suga", 25, "Amazon", "Amsterdam"));
        users.add(new User("Jimin", 30, "Uber", "New York"));

        Map<Integer, List<User>> userRegistration = User.registrationUser(users);
        System.out.println(userRegistration);
    }
}

