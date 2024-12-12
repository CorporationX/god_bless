package school.faang.task_43761;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("john", 25, "Uber", "Amsterdam"),
                new User("anna", 23, "Google", "London"),
                new User("mark", 19, "Amazon", "New York")
        );

        users.forEach(Main::safePrintUser);
    }

    private static void safePrintUser(User user) {
        try {
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.err.println("Error processing user: " + e.getMessage());
        }
    }
}
