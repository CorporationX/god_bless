package faang.school.godbless;

import faang.school.godbless.david.User;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Ura", 30, "Qwer", "Street 123"));
        users.add(new User("David", 25, "Asdf", "Street 456"));
        users.add(new User("Konstantin", 30, "Zxcv", "Street 789"));

        Map<Integer, List<User>> group = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : group.entrySet()) {
            System.out.println("Age" + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user);
            }
        }
    }
}
