package school.faang.groupUsers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Artem", "24", "Sber", "Rostov-on-Don"),
                new User("Tanya", "35", "Tinkoff", "Rostov-on-Don"),
                new User("Nazar", "21", "Auchan", "Rostov-on-Don"),
                new User("Misha", "24", "FixPrice", "Rostov-on-Don"),
                new User("Katya", "35", "Auchan", "Rostov-on-Don"),
                new User("Alena", "37", "Tinkoff", "Rostov-on-Don"),
                new User("Igor", "28", "Sber", "Rostov-on-Don"),
                new User("Dasha", "46", "FixPrice", "Rostov-on-Don"),
                new User("Matvei", "35", "Tinkoff", "Rostov-on-Don"),
                new User("Kirill", "60", "Sber", "Rostov-on-Don"),
                new User("Liza", "24", "Auchan", "Rostov-on-Don")
        );

        Map<String, List<User>> usersMap = User.groupUsers(users);

        for (Map.Entry<String, List<User>> entry : usersMap.entrySet()) {
            System.out.println("Key: " + entry.getKey());

            for (User user : entry.getValue()) {
                System.out.println(user);
            }

            System.out.println("- - - - - - - ");
        }
    }

}