package school.faang;

import school.faang.firsttask.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 30, "Company 1", "Address 1"));
        users.add(new User("Alex", 25, "Company 2", "Address 2"));
        users.add(new User("Stepan", 30, "Company 3", "Address 3"));

        Map<Integer, List<User>> grouped = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(" - " + user.getName());
            }
        }
    }
}
