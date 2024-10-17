package mod1sp12.groupingUsersByAge;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Denis", 22, "none", "Podolsk"),
                new User("Andrew", 32, "Metal", "Moscow"),
                new User("Karl", 33, "Berlin", "Cupertino"),
                new User("Lion", 33, "Apple", "Cupertino")
        );

        Map<Integer, List<User>> map = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}