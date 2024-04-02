package faang.school.godbless.grouping_users;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> initial = Arrays.asList(
                new User("Test1", 20, "Job1", "Address1"),
                new User("Test2", 19, "Job2", "Address2"),
                new User("Test3", 18, "Job3", "Address3"),
                new User("Test4", 20, "Job4", "Address4"),
                new User("Test4", 19, "Job4", "Address4"),
                new User("Test4", 19, "Job4", "Address4")
        );

        User.groupUsers(initial).forEach((age, users) -> System.out.printf("%s -> %s%n", age, users));
    }

}
