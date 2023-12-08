package faang.school.godbless.users;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("John", 23, "Ebay", "Berlin"));
        users.add(new User("Dean", 23, "Google", "Oslo"));
        users.add(new User("Sam", 23, "Meta", "New York"));
        users.add(new User("Crowley", 25, "Avito", "Denmark"));
        users.add(new User("Konstantin", 23, "VK", "Moscow"));
        users.add(new User("Jeremy", 25, "HH", "London"));

        User.groupUsers(users);
    }
}
