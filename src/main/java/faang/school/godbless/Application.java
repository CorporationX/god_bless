package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        User Bob = new User("Bob", 20, "Google", "Amsterdam");
        User Jack = new User("Jack", 20, "Amazon", "New York");
        User Van = new User("Van", 30, "Uber", "London");
        User Kate = new User("Kate", 20, "Google", "Amsterdam");

        users.add(Bob);
        users.add(Jack);
        users.add(Van);
        users.add(Kate);

        System.out.println(User.groupUsers(users));
    }
}