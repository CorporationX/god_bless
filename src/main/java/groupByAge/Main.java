package groupByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Vlad", 25, "Company A", "123 Street"));
        users.add(new User("Inna", 30, "Company B", "456 Avenue"));
        users.add(new User("Vitalik", 25, "Company C", "789 Road"));
        users.add(new User("Viktor", 30, "Company D", "321 Boulevard"));
        users.add(new User("Mike", 35, "Company E", "987 Lane"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (var entry : groupedUsers.entrySet()) {
            int age = entry.getKey();
            List<User> userList = entry.getValue();
            System.out.println("Age: " + age);
            for (User user : userList) {
                System.out.println(user.getName() + " works at " + user.getWorkPlace());
            }
            System.out.println();
        }
    }
}