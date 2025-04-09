package school.faang.bjs2_68215;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Artur", 37, "Google", "New York"),
                new User("Joseph", 23, "Uber", "Amsterdam"),
                new User("Jane", 23, "Amazon", "London"),
                new User("John", 25, "Uber", "New York")
        );

        users.forEach(user -> log.info(user.toString()));
    }
}