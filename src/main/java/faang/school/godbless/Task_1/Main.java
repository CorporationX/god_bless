package faang.school.godbless.Task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.Task_1.User.groupUsers;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        User user1 = new User("Vadim", 29, "Shibanov", "Moscow");
        User user2 = new User("Mike", 88, "Black", "Ohio");
        User user3 = new User("Jessica", 29, "Smith", "London");
        User user4 = new User("Danny", 44, "O'Brien", "New-York");
        User user5 = new User("Clare", 29, "Noname", "Moscow");
        User user6 = new User("Vadim", 29, "Shibanov", "Moscow");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        System.out.println(groupUsers(users).toString());
    }
}
