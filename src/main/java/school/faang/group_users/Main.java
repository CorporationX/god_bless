package school.faang.group_users;

import school.faang.group_users.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Nik", 50, "SperBankMoney", " Money St 777"));
        users.add(new User("cucumber", 20, "banduel", "vegetable 15 st"));
        users.add(new User("tomato", 20, "banduel", "vegetable 15 st"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            int age = entry.getKey();
            List<User> userList = entry.getValue();
            System.out.println("Age: " + age);
            for (User user : userList) {
                System.out.println("  - " + user.getName());
            }
        }
    }
}
