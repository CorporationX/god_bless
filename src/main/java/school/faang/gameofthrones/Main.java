package school.faang.gameofthrones;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> roles = new ArrayList<>();
        roles.add("Role 1");
        roles.add("Role 2");
        roles.add("Role 3");
        House house = new House("House1", roles);

        List<User> users = List.of(
                new User("User1"),
                new User("User2"),
                new User("User3"),
                new User("User4"),
                new User("User5")
        );
        users.forEach(user -> new Thread(() -> joinAndExitHouse(user, house)).start());
    }

    private static void joinAndExitHouse(User user, House house) {
        try {
            user.joinHouse(house);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted ...");
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
        user.leaveHouse(house);
    }
}
