package school.faang.task_44035;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 30, "Company A", "Address 1"));
        users.add(new User("Bob", 25, "Company B", "Address 2"));
        users.add(new User("Charlie", 30, "Company A", "Address 3"));
        users.add(new User("David", 25, "Company B", "Address 4"));
        users.add(new User("Eve", 35, "Company C", "Address 5"));

        for (User user : users) {
            System.out.println(user.groupUser(users).toString());
        }
    }
}
