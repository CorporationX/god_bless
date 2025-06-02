package school.faang;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Mike", 20, "SBER", "Moscow"),
                new User("Steve", 24, "YD", "Tver"),
                new User("Ann", 20, "X5", "St.Petersburg"),
                new User("Frank", 30, "Uber", "London"),
                new User("Hank", 25, "SBER", "Moscow"),
                new User("Mary", 24, "Yahoo", "Washington")
        );

        Map<Integer, List<User>> userMap = User.groupUsers(userList);

        for (Map.Entry<Integer, List<User>> entry : userMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
