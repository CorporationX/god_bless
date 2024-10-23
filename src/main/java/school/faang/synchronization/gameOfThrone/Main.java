package school.faang.synchronization.gameOfThrone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 4;
    private static final int THREAD_WAIT_TIME = 2000;
    private static final int THREAD_WORK_TIME = 100;

    public static void main(String[] args) {
        List<String> roles = List.of("knight", "witch", "mag");
        House house = new House(roles, "Stark");

        List<User> users = new ArrayList<>();
        users.add(new User("Abzalkhan"));
        users.add(new User("Olzhas"));
        users.add(new User("Aida"));

        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for (User user : users) {
            service.submit(() -> {
                try {
                    user.joinHouse(house);
                    Thread.sleep(THREAD_WAIT_TIME);
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
        try {
            if (!service.awaitTermination(THREAD_WORK_TIME, TimeUnit.SECONDS)) {
                service.shutdown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
