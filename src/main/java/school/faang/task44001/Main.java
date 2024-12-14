package school.faang.task44001;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Ivan", 24, "Remotely", "London"),
                new User("Tom", 38, "Office", "Moscow"),
                new User("Sam", 38, "Remotely", "Kazan"),
                new User("Anna", 29, "Remotely", "Saratov")
        );
        System.out.println(User.groupUsers(users));
    }
}