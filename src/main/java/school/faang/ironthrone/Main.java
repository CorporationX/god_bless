package school.faang.ironthrone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 4;
    private static final int TIME_TO_WAIT = 1000;
    private static final int TIME_TO_WORK = 100;

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        List<String> roles = List.of("Маг", "Войн");
        House firstHouse = new House(roles);
        users.add(new User("First"));
        users.add(new User("Second"));
        users.add(new User("Third"));
        users.add(new User("Fourth"));

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (User user : users) {
            executor.submit(() -> {
                try {
                    user.joinHouse(firstHouse);
                    Thread.sleep(TIME_TO_WAIT);
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIME_TO_WORK, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}