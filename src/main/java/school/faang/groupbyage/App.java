package school.faang.groupbyage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        User alice = new User("Alice", 30, "Компания 1", "123 Main St");
        User bob = new User("Bob", 25, "Компания 1", "456 Elm St");
        User stepan = new User("Stepan", 30, "Компания 1", "789 Maple Ave");
        User david = new User("David", 25, "Компания 1", "101 Oak St");
        User anton = new User("Anton", 30, "Компания 1", "789 Maple Ave");
        User vova = new User("Vova", 25, "Компания 1", "101 Oak St");
        User petya = new User("Petya", 30, "Компания 1", "123 Main St");
        User danya = new User("Danya", 25, "Компания 1", "456 Elm St");
        User tanya = new User("Tanya", 30, "Компания 1", "789 Maple Ave");
        User masha = new User("Masha", 25, "Компания 1", "101 Oak St");

        List<User> users = List.of(alice, bob, stepan, danya, david, anton, vova,
                petya, tanya, masha);

        Map<Integer, List<User>> result = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : result.entrySet()) {
            Integer age = entry.getKey();
            List<User> userList = entry.getValue();
            System.out.println("Age: " + age);
            for (User user : userList) {
                System.out.println(user.toString());
            }
        }
    }
}
