package school.faang.bjs2_68238;

import java.util.List;

public class Main {
    public static void main(String[] arguments) {
        try {
            new User(null, 25, "Google", "London");
        } catch (IllegalArgumentException exception) {
            System.out.println("Error creating user: " + exception.getMessage());
        }

        try {
            new User("Anna", 17, "Google", "London");
        } catch (IllegalArgumentException exception) {
            System.out.println("Error creating user: " + exception.getMessage());
        }

        try {
            new User("Peter", 25, "Yandex", "London");
        } catch (IllegalArgumentException exception) {
            System.out.println("Error creating user: " + exception.getMessage());
        }

        try {
            new User("Elena", 25, "Google", "Moscow");
        } catch (IllegalArgumentException exception) {
            System.out.println("Error creating user: " + exception.getMessage());
        }

        List<User> validUsers = List.of(
                new User("Ivan Petrov", 25, "Google", "London"),
                new User("Maria Sidorova", 30, "Uber", "New York"),
                new User("Alexey Nikolaev", 45, "Amazon", "Amsterdam")
        );

        validUsers.forEach(System.out::println);
    }
}
