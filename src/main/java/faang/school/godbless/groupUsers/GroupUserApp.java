package faang.school.godbless.groupUsers;

import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.groupUsers.User.groupUsers;

public class GroupUserApp {
    public static void main(String... args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Alice", 25, "Developer", "123 Street A"));
        users.add(new User("Bob", 30, "Designer", "456 Street B"));
        users.add(new User("Charlie", 25, "Artist", "789 Street C"));
        users.add(new User("David", 28, "Engineer", "321 Street D"));
        users.add(new User("Eve", 32, "Manager", "654 Street E"));
        users.add(new User("Frank", 40, "Teacher", "987 Street F"));


        System.out.println(groupUsers(users).get(25));
    }
}
