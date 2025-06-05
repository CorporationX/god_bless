package school.faang.grouping;

import java.util.List;
import java.util.Map;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var users = List.of(
                new User("Danil", 25, "Galaxy42 Co. Ltd", "Perm"),
                new User("Ivan", 25, "Emerald Co. Ltd", "Moscow"),
                new User("Sergey", 26, "Voice Tech Ltd", "Saint Petersburg"),
                new User("Vladimir", 26, "Lux AI Tech Ltd", "Saint Petersburg")
        );
        var usersByAge = User.groupUsers(users);
        for (var usersEntry : usersByAge.entrySet()) {
            System.out.println(usersEntry.getKey() + ":");
            for (var user : usersEntry.getValue()) {
                System.out.println(" " + user);
            }
        }
    }
}
