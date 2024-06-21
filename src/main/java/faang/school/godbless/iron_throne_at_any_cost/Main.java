package faang.school.godbless.iron_throne_at_any_cost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Map<Role, Integer> roles = new HashMap<>();
        roles.put(Role.KNIGHT, 2);
        roles.put(Role.LORD, 2);
        roles.put(Role.WIZARD, 2);

        House house = new House(roles);

        List<User> users = new ArrayList<>();
        users.add(new User("Player1", house, Role.KNIGHT));
        users.add(new User("Player2", house, Role.KNIGHT));
        users.add(new User("Player3", house, Role.LORD));
        users.add(new User("Player4", house, Role.LORD));
        users.add(new User("Player5", house, Role.WIZARD));
        users.add(new User("Player6", house, Role.WIZARD));
        users.add(new User("Player7", house, Role.WIZARD));

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (User user : users) {
            executorService.execute(() -> {
                try {
                    user.joinHouse();
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                user.leaveHouse();
            });
        }

        executorService.shutdown();
    }
}
