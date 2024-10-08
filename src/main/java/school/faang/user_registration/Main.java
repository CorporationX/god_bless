package school.faang.user_registration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Alice", 18, "Google", "New York"),
                new User("Alice Johnson", 28, "Amazon", "London"),
                new User("Bob Smith", 34, "Uber", "Amsterdam"),
                new User("Charlie Brown", 30, "Amazon", "New York"),
                new User("Daisy Miller", 25, "Google", "London"),
                new User("Ethan Wright", 29, "Amazon", "New York"),
                new User("Fiona Davis", 31, "Uber", "London"),
                new User("George Wilson", 40, "Uber", "New York"),
                new User("Hannah Clark", 25, "Google", "London"),
                new User("Ian Lewis", 35, "Uber", "New York"),
                new User("Jenna Hall", 27, "Google", "London")
        );

        System.out.println(User.groupUsers(userList));
    }
}

