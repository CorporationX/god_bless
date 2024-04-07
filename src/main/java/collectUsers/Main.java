package collectUsers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> activities = Set.of("Football", "Basketball", "Volleyball", "Chess");
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Bob", 27, Set.of("Football", "Chess")));
        users.add(new User(2, "Nataly", 22, Set.of("Volleyball", "Basketball")));
        users.add(new User(3, "Sasha", 19, Set.of("Football", "Basketball")));
        users.add(new User(4, "Paul", 41, Set.of("Chess", "Football")));
        users.add(new User(5, "Aleftina", 34, Set.of("Volleyball", "Chess")));
        users.add(new User(6, "Roma", 29, Set.of("Programming", "Cook")));

        for (Map.Entry<User, String> entry : User.findHobbyLovers(users, activities).entrySet()) {
            System.out.println(entry.getKey().getName() + " любит " + entry.getValue());
        }
    }
}
