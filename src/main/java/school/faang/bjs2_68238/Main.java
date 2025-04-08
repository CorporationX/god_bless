package school.faang.bjs2_68238;

import java.util.Set;

import static java.util.Set.of;

public class Main {
    public static void main(String[] arguments) {
        try {
            new User("", 25, "Google", "London");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error creating user: " + ex.getMessage());
        }

        try {
            new User("Anna", 17, "Google", "London");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error creating user: " + ex.getMessage());
        }

        try {
            new User("Peter", 25, "Yandex", "London");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error creating user: " + ex.getMessage());
        }

        try {
            new User("Elena", 25, "Google", "Moscow");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error creating user: " + ex.getMessage());
        }

        Set<User> validUsers = of(
                new User("Ivan Petrov", 25, "Google", "London"),
                new User("Maria Sidorova", 30, "Uber", "New York"),
                new User("Alexey Nikolaev", 45, "Amazon", "Amsterdam")
        );

        validUsers.forEach(System.out::println);
    }
}
