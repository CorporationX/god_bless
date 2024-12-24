package school.faang.sprint_3.task_48822;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMBER_OF_THREADS = 4;
    private static final int NUMBER_OF_USERS = 16;
    private static final int USER_IN_HOUSE_TIME = 1000;
    private static final int AWAIT_DELAY = 1;

    public static void main(String[] args) {
        List<String> roles = Arrays.asList("King",
                "Lord",
                "Swordsman",
                "Archer");

        House house = new House("House 1", roles);

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 1; i <= NUMBER_OF_USERS; i++) {
            int finalI = i;
            executorService.submit(() -> {
                User user = new User("User " + finalI);
                user.joinHouse(house);
                try {
                    Thread.sleep(USER_IN_HOUSE_TIME);
                } catch (InterruptedException e) {
                    System.out.println("User " + finalI + " in house time was interrupted");
                    Thread.currentThread().interrupt();
                }
                user.leaveHouse();
            });
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_DELAY, TimeUnit.MINUTES)) {
                System.out.println("Await timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted. Shutting down...");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
