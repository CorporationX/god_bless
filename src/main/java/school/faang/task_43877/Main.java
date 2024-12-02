package school.faang.task_43877;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        users.add(new User("TestUser1", 20, "TestWorkplace1", "TestAddress1"));
        users.add(new User("TestUser2", 30, "TestWorkplace1", "TestAddress2"));
        users.add(new User("TestUser3", 20, "TestWorkplace2", "TestAddress3"));
        users.add(new User("TestUser4", 40, "TestWorkplace2", "TestAddress4"));
        users.add(new User("TestUser5", 40, "TestWorkplace3", "TestAddress5"));
        users.add(new User("TestUser6", 30, "TestWorkplace3", "TestAddress6"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> groupedUsersEntrySet : groupedUsers.entrySet()) {
            System.out.println("Age group: " + groupedUsersEntrySet.getKey());
            for (User user : groupedUsersEntrySet.getValue()) {
                System.out.println(user);
            }
            System.out.println("-----------------------------------------------------");
        }
    }
}
