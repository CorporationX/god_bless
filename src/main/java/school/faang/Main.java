package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(new User("Alexander", 20, "SNG", "Surgut"),
                new User("Timur", 25, "Administration", "Moscow"),
                new User("Denis", 20, "RosNeft", "EKB"),
                new User("Kirill", 24, "SNG","Surgut"),
                new User("Artur", 25, "Administration", "Novosibirsk"),
                new User("Artem", 24, "SNG", "Surgut"));

        Map<Integer, List<User>> result = User.groupUsers(userList);
        System.out.println(result);

    }
}
