package school.faang;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@AllArgsConstructor
public class User {
    private final String name;
    private final int age;
    private String work;
    private final String address;

    public static void main(String[] args) {
        User damba = new User("Damba", 36, "X5", "Moscow, Koroviy Val");
        User kit = new User("Kit", 35, "Military", "Moscow");
        User mongol = new User("Mongol", 36, "GosCap", "Moscow, Lubyanka");
        User vasilisa = new User("Vasilisa", 42, "GosCollector", "Moscow");

        List<User> users = new ArrayList<>(Arrays.asList(damba, kit, mongol, vasilisa));

        printMapUser(groupUsersOrAge(users));
    }

    private static void printMapUser(HashMap<Integer, List<User>> mapUsers) {
        if (mapUsers != null) {
            for (Map.Entry<Integer, List<User>> user : mapUsers.entrySet()) {
                System.out.println(user);
            }
        }
    }

    private static HashMap<Integer, List<User>> groupUsersOrAge(List<User> listUsers) {
        if (listUsers != null) {
            HashMap<Integer, List<User>> mapUsers = new HashMap<>();
            for (User user : listUsers) {
                mapUsers.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
            }
            return mapUsers;
        }
        return null;
    }

}
