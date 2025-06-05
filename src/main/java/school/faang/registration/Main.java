package school.faang.registration;

import java.util.List;
import java.util.Set;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var users = List.of(
                tryCreateUser(null, 17, "someJob1", "someAddress1"),
                tryCreateUser("", 17, "someJob2", "someAddress2"),
                tryCreateUser("Sergey", 17, "someJob3", "someAddress3"),
                tryCreateUser("Danil", 25, "someJob4", "someAddress4"),
                tryCreateUser("Ivan", 27, "Google", "someAddress5"),
                tryCreateUser("Bogdan", 24, "Google", "Amsterdam")
        );
        System.out.println();
        for (var user : users) {
            if (!User.INVALID.equals(user)) {
                System.out.println(user);
            }
        }
    }

    private static User tryCreateUser(String userName, Integer age, String jobName, String address) {
        try {
            return new User(userName, age, jobName, address);
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return User.INVALID;
    }
}
