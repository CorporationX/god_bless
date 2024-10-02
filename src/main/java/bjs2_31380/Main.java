package bjs2_31380;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Ann", 25, "hr", "address1"),
                new User("Bob", 25, "frontend", "address2"),
                new User("John", 29, "designer", "address3"),
                new User("JD", 31, "md", "address4"),
                new User("Eliot", 31, "md", "address4")
        );

        System.out.println(User.groupUsers(users));
    }
}
