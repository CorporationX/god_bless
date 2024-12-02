package school.faang.bjs243922;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        User user = new User("Muhammad", 21, "IT", "Tashkent");
        User user1 = new User("Muhammad", 21, "IT", "Tashkent");
        User user2 = new User("Muhammad", 21, "IT", "Tashkent");
        User user3 = new User("Muhammad", 45, "IT", "Tashkent");
        User user4 = new User("Muhammad", 77, "IT", "Tashkent");
        User user5 = new User("Muhammad", 77, "IT", "Tashkent");
        User user6 = new User("Muhammad", 89, "IT", "Tashkent");

        List<User> users = List.of(
                user,
                user1,
                user2,
                user3,
                user4,
                user5,
                user6
        );

        Map<Integer, List<User>> result = user.groupUsers(users);

        result.forEach((k, v) -> {
            System.out.println("KEY : " + k + "\nVALUES :" + v);
        });

    }
}
