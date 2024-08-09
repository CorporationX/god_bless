package faang.school.godbless.bjs218461;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User("Dale", 30, "Uber", "New York"),
                new User("Carlos", 18, "Amazon", "London"),
                new User("Frank", 30, "Amazon", "London"),
                new User("Richard", 30, "Amazon", "Amsterdam"),
                new User("Bob", 29, "Uber", "Amsterdam"),
                new User("Michael", 29, "Uber", "Amsterdam"),
                new User("Garry", 18, "Google", "Amsterdam"),
                new User("Daryl", 20, "Google", "Amsterdam")
        );

        System.out.println(User.groupUsers(users));
    }
}