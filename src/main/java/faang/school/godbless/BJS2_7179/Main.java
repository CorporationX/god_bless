package faang.school.godbless.BJS2_7179;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(0, "Petya", 18, Set.of("Fishing", "Diving", "Drawing")));
        users.add(new User(1, "Zhenya", 18, Set.of("Cycling", "Driving", "Drawing")));
        users.add(new User(2, "Lena", 18, Set.of("Eating")));
        System.out.println(User.findHobbyLovers(users, Set.of("123", "Drawing", "222")));
    }
}
