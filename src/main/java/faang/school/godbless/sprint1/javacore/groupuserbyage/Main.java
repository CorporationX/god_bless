package faang.school.godbless.sprint1.javacore.groupuserbyage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Mila", 35, "Google", "Mila's address"));
        users.add(new User("Gosha", 27, "Amazon", "Gosha's address"));
        users.add(new User("Richard", 35, "Amazon", "Richard's address"));
        users.add(new User("Erica", 27, "Netflix", "Erica's address"));
        users.add(new User("Joris", 23, "IBM", "Joris's address"));

        Map<Integer, List<User>> groupedUsersByAge = User.groupUsers(users);

        printGroupedUsers(groupedUsersByAge);
    }

    private static void printGroupedUsers(Map<Integer, List<User>> groupedUsers) {
        groupedUsers.forEach((age, users) -> {
            System.out.println("Age: " + age + " Users: ");
            users.forEach(user -> System.out.println("  " + user));
        });
    }
}
