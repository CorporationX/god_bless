package ironThrone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_OF_THREADS = 5;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(NUM_OF_THREADS);

        Map<String, Locker> roles = new HashMap<>();
        roles.put("King", new Locker(true));
        roles.put("Swordman", new Locker(true));
        roles.put("Archer", new Locker(true));
        roles.put("Salesman", new Locker(true));

        House house = new House("Lannisters", roles);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User("User " + i));
        }

        users.forEach(user -> service.execute(() -> {
            user.joinHouse(house);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user.leaveHouse();
        }));

        service.shutdown();
    }
}
