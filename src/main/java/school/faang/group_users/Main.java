package school.faang.group_users;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var userList = new ArrayList<User>(List.of(new User("Igor", 28, "Theatre", "Rostov"),
                new User("Igor", 28, "Theatre", "Rostov"),
                new User("Roman", 28, "Theatre", "Rostov"),
                new User("Vera", 29, "Theatre", "Rostov"),
                new User("Nika", 33, "Theatre", "Rostov"),
                new User("Marina", 44, "Theatre", "Rostov")
                ));

        var map = User.groupUsers(userList);
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
    }
}
