package school.faang.sprint_1.task_43895;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User firstUser = new User("Tom", 18, "Meta", "New-York, 1-street");
        User secondUser = new User("Kevin", 22, "Microsoft", "Los-Angeles, 2-street");
        User thirdUser = new User("Jack", 18, "Amazon", "London, 3-street");
        User fourthUser = new User("John", 20, "Google", "Berlin, 4-street");

        List<User> users = new ArrayList<>();

        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);
        users.add(fourthUser);

        System.out.println(User.groupUsers(users));
    }
}
