package school.faang.task_44015;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = User.createUsers();
        Map<Integer, List<User>> usersByAge = User.groupUsersByAge(users);
        User.printUsersByAge(usersByAge);
    }
}