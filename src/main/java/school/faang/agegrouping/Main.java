package school.faang.agegrouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.agegrouping.User.groupUsers;

/*
 * Related to JIRA ticket: BJS2-68095
 */
public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Alice", 25, "Company A", "Address 1"));
        userList.add(new User("Bob", 30, "Company B", "Address 2"));
        userList.add(new User("Charlie", 25, "Company C", "Address 3"));
        userList.add(new User("David", 30, "Company D", "Address 4"));
        userList.add(new User("Eve", 35, "Company E", "Address 5"));

        Map<Integer, List<User>> groupedUsers = groupUsers(userList);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("\t" + user);
            }
        }
    }
}
