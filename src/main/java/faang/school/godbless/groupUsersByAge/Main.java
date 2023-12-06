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
                new User("Erick", 32, "Facebook", "Los-Angeles"),
                new User("Bred", 31, "Amazon", "New-York"),
                new User("John", 31, "Facebook", "Los-Angeles"),
                new User("Seth", 30, "Amazon", "New-York"),
                new User("Palmer", 30, "Facebook", "Las-Vegas"),
                new User("Eddy", 35, "Amazon", "Las-Vegas"),
                new User("Christopher", 35, "Facebook", "Los-Angeles"),
                new User("Kenny", 28, "Amazon", "Las-Vegas"),
                new User("Collin", 28, "Facebook", "Las-Vegas")
        );
    }
}
