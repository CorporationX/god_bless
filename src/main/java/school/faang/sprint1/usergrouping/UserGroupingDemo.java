package school.faang.sprint1.usergrouping;

import java.util.ArrayList;
import java.util.List;

public class UserGroupingDemo {

    public static void main(String[] args) {

        System.out.println(User.groupUsers(getUsers()));

    }

    private static List<User> getUsers() {
        List<User> users = new ArrayList<>(List.of(
            new User("User1", 18, "Google", "one"),
            new User("User2", 25, "Amazon", "two"),
            new User("User3", 45, "Meta", "three"),
            new User("User4", 25, "Google", "four"),
            new User("User5", 30, "Amazon", "five"),
            new User("User6", 35, "Meta", "six"),
            new User("User7", 30, "Meta", "seven")));
        users.add(null);
        return users;
    }


}
