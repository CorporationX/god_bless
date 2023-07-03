package sprint4.throne;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class IronThrone {
    private static final Map<String, Integer> roles = new HashMap<>();
    static {
        roles.put("Lord", 1);
        roles.put("Wizard",1);
        roles.put("Knight", 4);
    }
    private static final House HOUSE = new House(roles);
    private static final int NUM_THREAD = 10;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREAD);

        for (int i = 0; i < NUM_THREAD; i++) {
            User user = new User("Player " + i);
            service.execute(() -> {
                user.joinHouse(HOUSE);
                playForRole();
                user.leaveHouse();
            });
        }
        service.shutdown();

        try {
            service.awaitTermination(12, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Work interrupted");
        }
    }

    private static void playForRole() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
