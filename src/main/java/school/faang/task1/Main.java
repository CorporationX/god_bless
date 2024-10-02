package school.faang.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.task1.User.addUserToList;
import static school.faang.task1.User.printGroupedUsers;
import static school.faang.task1.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        addUserToList(users, new User("User 1", 20, "Company 1", "Address 111"));
        addUserToList(users, new User("User 2", 18, "Company 2", "Address 222"));
        addUserToList(users, new User("User 3", 20, "Company 3", "Address 333"));
        addUserToList(users, new User("User 4", 48, "Company 4", "Address 444"));
        addUserToList(users, new User("User 5", 50, "Company 5", "Address 555"));
        addUserToList(users, new User("User 6", 20, "Company 6", "Address 666"));
        addUserToList(users, new User("User 7", 30, "Company 7", "Address 777"));
        addUserToList(users, new User("User 8", 18, "Company 8", "Address 888"));
        addUserToList(users, new User("User 9", 50, "Company 9", "Address 999"));

        Map<Integer, List<User>> sortedUsers = groupUsers(users);
        printGroupedUsers(sortedUsers);
    }
}
