package school.faang.group_user_by_age;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        var users = List.of(
                new User("Sam", 24, "Google", "Washington DC"),
                new User("Ban", 24, "Amazon", "Miami"),
                new User("Ken", 21, "Amazon", "Chicago"),
                new User("Keanu", 21, "Netflix", "California"),
                new User("Man", 32, "Netflix", "New York"),
                new User("John", 32, "Microsoft", "Texas")
        );

        User.groupUsers(users).entrySet().forEach(System.out::println);
    }
}
