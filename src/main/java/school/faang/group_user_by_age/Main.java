package school.faang.group_user_by_age;

import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        var users = List.of(
                new User("Sam", 24, "Google", "London"),
                new User("Ban", 24, "Amazon", "London"),
                new User("Ken", 21, "Amazon", "New York"),
                new User("Keanu", 21, "Uber", "Amsterdam"),
                new User("Man", 32, "Uber", "New York"),
                new User("John", 32, "Uber", "Amsterdam")
        );

        User.groupUsers(users).entrySet().forEach(System.out::println);
    }
}
