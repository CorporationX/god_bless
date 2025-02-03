package users.groups;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Lily", 25, "Google", "New York"));
        users.add(new User("Tom", 30, "Facebook", "San Francisco"));
        users.add(new User("Harry", 25, "Amazon", "Seattle"));
        users.add(new User("David", 30, "Apple", "los Angeles"));
        users.add(new User("John", 35, "Microsoft", "Portland"));

        System.out.println(User.groupUsers(users));
    }
}
