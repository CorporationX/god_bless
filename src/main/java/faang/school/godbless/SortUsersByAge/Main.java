package faang.school.godbless.SortUsersByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("George", 24, "IT", "Wall Street 19");
        User user2 = new User("Gennady", 40, "Marketing", "Patriki 23");
        User user3 = new User("Elizabeth", 24, "HR", "La Rosshe 13");

        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);

        Map<Integer, List<User>> sortedByAge = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : sortedByAge.entrySet()) {
            System.out.println("Users with age " + entry.getKey() + ":");
            for (User user : entry.getValue()) {
                System.out.println(user.getName() + ", " + user.getWorkplace() + ", " + user.getAddress());
            }
            System.out.println();
        }
    }
}
