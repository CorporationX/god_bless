package school.faang.task_56388;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User theodore = new User("Theodore", 27, "Columbia University", "New York");
        User robin = new User("Robin", 25, "World Wide News", "New York");
        User marshall = new User("Marshall", 27, "National bank Goliath", "New York");
        User lily = new User("Lily", 27, "Kindergarten", "New York");
        User barney = new User("Barney", 30, "National bank Goliath", "New York");
        List<User> users = new ArrayList<>(Arrays.asList(theodore, robin, marshall, lily, barney));

        Map<Integer, List<User>> groupedUsersByAge = User.groupUsers(users);
        groupedUsersByAge.forEach((usersAge, usersList) -> System.out.println("Users Age: " + usersAge
                + "\n" + "Users: " + usersList + "\n"));
    }
}
