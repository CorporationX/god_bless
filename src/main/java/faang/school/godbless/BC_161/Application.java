package faang.school.godbless.BC_161;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String... args) {
        List<User> userList = List.of(
                new User("Adam", 34, "Sysadmin", "Grozny"),
                new User("Salman", 30, "Student", "Urus"),
                new User("Mamed", 38, "Student", "Goiti"),
                new User("Adam2", 34, "Sysadmin", "Grozny"),
                new User("Salman2", 30, "Student", "Urus"),
                new User("Mamed2", 38, "Student", "Goiti")
        );

        for (Map.Entry key : User.groupUsers(userList).entrySet()) {
            System.out.println(key.getKey() + " = " + key.getValue());
        }
    }
}
