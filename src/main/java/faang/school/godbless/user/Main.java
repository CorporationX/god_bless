package faang.school.godbless.user;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Joffrey", 17, "Microsoft", "Mountain View"),
                new User("John", 27, "Microsoft", "Mountain View"),
                new User("Sergey", 22, "Microsoft", "Mountain View"),
                new User("Larey", 17, "Microsoft", "Mountain View"),
                new User("Mann", 17, "Microsoft", "Mountain View"),
                new User("Liam", 26, "Microsoft", "Mountain View"),
                new User("Ben", 26, "Microsoft", "Mountain View"),
                new User("Vlad", 38, "Microsoft", "Mountain View"),
                new User("Noah", 21, "Microsoft", "Mountain View"),
                new User("Mads", 21, "Microsoft", "Mountain View")
        );

        User.groupUsers(users).forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
