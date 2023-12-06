package faang.school.godbless.groupUsers;

import java.util.List;

import static faang.school.godbless.groupUsers.User.groupUsers;

public class GroupUserApp {
    public static void main(String... args) {
        List<User> users = List.of(
                new User("Alice", 17, "Developer", "123 Street A"),
                new User("Alice", 25, "Developer", "123 Street A"),
                new User("Bob", 30, "Designer", "456 Street B"),
                new User("Charlie", 25, "Artist", "789 Street C"),
                new User("David", 28, "Engineer", "321 Street D"),
                new User("Eve", 32, "Manager", "654 Street E"),
                new User("Frank", 40, "Teacher", "987 Street F")
                );

        System.out.println(groupUsers(users).get(25));
    }
}
