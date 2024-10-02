package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("User1", 1, "Company1", "Address1"),
                new User("User2", 1, "Company2", "Address2"),
                new User("User3", 2, "Company3", "Address3"),
                new User("User4", 2, "Company4", "Address4"),
                new User("User5", 3, "Company5", "Address5")
        );

        System.out.println(User.groupUsers(users));
    }
}
