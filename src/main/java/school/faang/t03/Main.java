package school.faang.t03;

import school.faang.t01.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<User> USERS = new ArrayList<>();

    public static void main(String[] args) {
        USERS.add(new User("Egor", 17, "Google", "London"));
        USERS.add(new User("Masha", 23, "Uber", "Amsterdam"));
        USERS.add(new User("Pasha", 24, "Yasha", "Moskow"));
        USERS.add(new User("Sasha", 23, "Amazon", "New York"));

        Map<Integer, List<User>> result = User.groupUsers(USERS);

        for (Map.Entry<Integer, List<User>> entry : result.entrySet()) {
            System.out.println("Age: " + entry);
        }
    }
}
