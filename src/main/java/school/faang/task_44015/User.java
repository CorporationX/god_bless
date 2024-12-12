package school.faang.task_44015;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public record User(String name, int age, String workplace, String address) {
    public static List<User> createUsers() {
        return List.of(
                new User("Mark Zuckerberg", 40, "Meta", "Menlo Park, CA"),
                new User("Evan Spiegal", 40, "Snapchat", "Santa Monica, CA"),
                new User("Jack Dorsey", 47, "Twitter", "San Francisco, CA"),
                new User("Brian Chesky", 41, "Airbnb", "San Francisco, CA"),
                new User("Travis Kalanick", 47, "Uber", "San Francisco, CA"));
    }

    public static Map<Integer, List<User>> groupUsersByAge(@NonNull List<User> users) {
        if (users.isEmpty()) {
            throw new IllegalArgumentException("Users cannot be empty!");
        }

        return users.stream().collect(Collectors.groupingBy(User::age));
    }

    public static void printUsersByAge(@NonNull Map<Integer, List<User>> usersByAge) {
        if (usersByAge.isEmpty()) {
            throw new IllegalArgumentException("Users cannot be empty!");
        }

        usersByAge.forEach((age, users) -> {
            log.info("Age: {}", age);
            users.forEach(user -> log.info("{} ({}) from {}", user.name, user.workplace, user.address));
        });
    }
}