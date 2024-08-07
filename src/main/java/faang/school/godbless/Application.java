package faang.school.godbless;

import faang.school.godbless.david.User;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        try{
            List<User> users = new ArrayList<>();
            users.add(new User("Ura", 30, "Google", "London"));
            users.add(new User("David", 25, "Uber", "Amsterdam"));
            users.add(new User("Konstantin", 30, "Amazon", "New York"));

            Map<Integer, List<User>> group = User.groupUsers(users);

            for (Map.Entry<Integer, List<User>> entry : group.entrySet()) {
                System.out.println("Age" + entry.getKey());
                for (User user : entry.getValue()) {
                    System.out.println(user);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
