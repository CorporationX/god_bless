package faang.school.godbless.bjs2_24231;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static faang.school.godbless.bjs2_24231.Role.KNIGHT;
import static faang.school.godbless.bjs2_24231.Role.LORD;
import static faang.school.godbless.bjs2_24231.Role.MAGICIAN;

public class Main {
    private static final int USERS_AMOUNT = 10;
    private static final int THREAD_POOL_SIZE = USERS_AMOUNT;

    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static void main(String[] args) {
        House house = initHouse();
        List<User> users = initUsers();

        users.forEach(user -> {
            executor.execute(() -> processUser(user, house));
        });

        executor.shutdown();
    }

    private static void processUser(User user, House house) {
        user.joinHouse(house);

        try {
            Thread.sleep(1000L * (new Random().nextInt(5) + 1));
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }

        user.leaveHouse();
    }

    private static House initHouse() {
        Map<Role, Integer> roles = initRoles();
        return new House(roles);
    }

    private static Map<Role, Integer> initRoles() {
        Map<Role, Integer> roles = new HashMap<>();
        roles.put(LORD, 1);
        roles.put(KNIGHT, 2);
        roles.put(MAGICIAN, 1);
        return roles;
    }

    private static List<User> initUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= USERS_AMOUNT; i++) {
            users.add(new User("u" + i));
        }
        return users;
    }
}
