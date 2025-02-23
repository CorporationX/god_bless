package school.faang.the_iron_throne_at_any_cost.BJS2_61550;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {
        List<String> roles = new ArrayList<>(List.of("лорд", "рыцарь", "маг"));
        House house = new House(roles);
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int finalI = i;
            executorService.submit(() -> {
                User user = new User("User " + finalI);
                try {
                    user.joinHouse(house);
                    Thread.sleep(3000);
                    user.leaveHouse(house);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
