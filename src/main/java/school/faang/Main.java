package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User firstUser = new User("John", 23, "London", "Google");
        User secondUser = new User("Stu", 18, "New York", "Amazon");
        User thirdUser = new User("Steve", 23, "Amsterdam", "Uber");
        User fourthUser = new User("Ada", 19, "London", "Google");

        List<User> users = new ArrayList<>();
        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);
        users.add(fourthUser);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey() + " -> Users: " + entry.getValue());
        }
    }
}

