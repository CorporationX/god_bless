package school.faang.t01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final List<User> USERS = new ArrayList<>();

    public static void main(String[] args) {
        USERS.add(new User("Egor", 18, "it", "Spb"));
        USERS.add(new User("Masha", 23, "it", "Msk"));
        USERS.add(new User("Pasha", 24, "it", "Ekb"));
        USERS.add(new User("Sasha", 23, "it", "Oms"));

        Map<Integer, List<User>> result = User.groupUsers(USERS);

        for (Map.Entry<Integer, List<User>> entry : result.entrySet()) {
            System.out.println("Age: " + entry);
        }
    }
}
