package TheIronThrone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        House stark = new House("Stark");

        List<User> users = new ArrayList<>();
        users.add(new User("user_1", stark, Role.LORD));
        users.add(new User("user_2", stark, Role.KNIGHT));
        users.add(new User("user_3", stark, Role.BASTARD));
        users.add(new User("user_4", stark, Role.LORD));

        for (User user : users) {
            service.execute(() -> user.joinHouse());
        }

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (User user : users) {
            service.execute(() -> user.leaveHouse());
        }

        service.shutdown();
    }
}
