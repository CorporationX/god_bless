package faang.school.godbless.groupUsersByAge;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, List<User>> group = User.groupUsers(createUsers());

        group.forEach((key, value) -> System.out.println(key + ":" + value));
    }
    private static List<User> createUsers() {
        return List.of(
                new User("John", 32, "Amazon", "New-York"),
                new User("Erick", 32, "Google", "London"),
                new User("Bred", 31, "Amazon", "New-York"),
                new User("John", 31, "Google", "London"),
                new User("Seth", 30, "Amazon", "New-York"),
                new User("Palmer", 30, "Google", "London"),
                new User("Eddy", 35, "Uber", "London"),
                new User("Christopher", 35, "Google", "Amsterdam"),
                new User("Kenny", 28, "Amazon", "Amsterdam"),
                new User("Collin", 28, "Uber", "Amsterdam")
        );
    }
}
